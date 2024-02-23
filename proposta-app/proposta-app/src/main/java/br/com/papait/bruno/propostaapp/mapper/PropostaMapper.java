package br.com.papait.bruno.propostaapp.mapper;

import br.com.papait.bruno.propostaapp.dto.PropostaRequestDto;
import br.com.papait.bruno.propostaapp.entity.PropostaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PropostaMapper {


  @Mapping(target = "usuario.nome", source = "nome")
  @Mapping(target = "usuario.sobrenome", source = "sobrenome")
  @Mapping(target = "usuario.cpf", source = "cpf")
  @Mapping(target = "usuario.telefone", source = "telefone")
  @Mapping(target = "usuario.renda", source = "renda")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "aprovada", ignore = true)
  @Mapping(target = "integrada", ignore = true)
  @Mapping(target = "observacao", ignore = true)
  PropostaEntity convertDtoToProposta(PropostaRequestDto propostaRequestDto);
}
