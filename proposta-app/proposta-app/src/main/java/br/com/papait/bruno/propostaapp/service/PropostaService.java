package br.com.papait.bruno.propostaapp.service;

import br.com.papait.bruno.propostaapp.dto.PropostaRequestDto;
import br.com.papait.bruno.propostaapp.dto.PropostaResponseDto;
import br.com.papait.bruno.propostaapp.mapper.PropostaMapper;
import br.com.papait.bruno.propostaapp.repository.PropostaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PropostaService {

  private final PropostaRepository propostaRepository;

  public PropostaResponseDto criarProposta(final PropostaRequestDto propostaRequestDto) {
    var proposta = PropostaMapper.INSTANCE.convertDtoToPropostaEntity(propostaRequestDto);
    this.propostaRepository.save(proposta);

    return PropostaMapper.INSTANCE.convertPropostaEntityToDto(proposta);
  }
}
