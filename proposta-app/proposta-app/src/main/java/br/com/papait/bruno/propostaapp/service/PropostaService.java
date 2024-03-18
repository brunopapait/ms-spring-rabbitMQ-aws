package br.com.papait.bruno.propostaapp.service;

import br.com.papait.bruno.propostaapp.dto.PropostaRequestDto;
import br.com.papait.bruno.propostaapp.dto.PropostaResponseDto;
import br.com.papait.bruno.propostaapp.mapper.PropostaMapper;
import br.com.papait.bruno.propostaapp.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PropostaService {

  private final PropostaRepository propostaRepository;
  private NotificacaoService notificacaoService;

  public PropostaResponseDto criarProposta(final PropostaRequestDto propostaRequestDto) {
    var proposta = PropostaMapper.INSTANCE.convertDtoToPropostaEntity(propostaRequestDto);
    this.propostaRepository.save(proposta);

    var propostaResponse =  PropostaMapper.INSTANCE.convertPropostaEntityToDto(proposta);
    this.notificacaoService.enviarNotificacao(propostaResponse, "proposta-pendente.ex");

    return propostaResponse;
  }

  public List<PropostaResponseDto> obterPropostas() {
    var propostas = this.propostaRepository.findAll();
    return propostas.stream().map(PropostaMapper.INSTANCE::convertPropostaEntityToDto).toList();
  }
}
