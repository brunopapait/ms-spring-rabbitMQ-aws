package br.com.papait.bruno.propostaapp.service;

import br.com.papait.bruno.propostaapp.dto.PropostaRequestDto;
import br.com.papait.bruno.propostaapp.dto.PropostaResponseDto;
import br.com.papait.bruno.propostaapp.entity.PropostaEntity;
import br.com.papait.bruno.propostaapp.mapper.PropostaMapper;
import br.com.papait.bruno.propostaapp.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PropostaService {

  private final PropostaRepository propostaRepository;
  private final NotificacaoService notificacaoService;
  private final String exchange;

  public PropostaService(
      PropostaRepository propostaRepository,
      NotificacaoService notificacaoService,
      @Value("${rabbitmq.propostapendente.exchange}") String exchange
  ) {
    this.propostaRepository = propostaRepository;
    this.notificacaoService = notificacaoService;
    this.exchange = exchange;
  }

  public PropostaResponseDto criarProposta(final PropostaRequestDto propostaRequestDto) {
    var proposta = PropostaMapper.INSTANCE.convertDtoToPropostaEntity(propostaRequestDto);
    this.propostaRepository.save(proposta);

    this.enviarNotificacaoRabbitMQ(proposta);
    return PropostaMapper.INSTANCE.convertPropostaEntityToDto(proposta);
  }

  private void enviarNotificacaoRabbitMQ(final PropostaEntity propostaEntity) {
    try {
      this.notificacaoService.enviarNotificacao(propostaEntity, exchange);
    } catch (RuntimeException ex) {
      propostaEntity.setIntegrada(false);
      this.propostaRepository.save(propostaEntity);
    }
  }

  public List<PropostaResponseDto> obterPropostas() {
    var propostas = this.propostaRepository.findAll();
    return propostas.stream().map(PropostaMapper.INSTANCE::convertPropostaEntityToDto).toList();
  }
}
