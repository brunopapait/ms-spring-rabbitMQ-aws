package br.com.papait.bruno.propostaapp.mapper;

import br.com.papait.bruno.propostaapp.dto.PropostaRequestDto;
import br.com.papait.bruno.propostaapp.dto.PropostaResponseDto;
import br.com.papait.bruno.propostaapp.entity.PropostaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PropostaMapper {

  PropostaMapper INSTANCE = Mappers.getMapper(PropostaMapper.class);


  @Mapping(target = "usuario.nome", source = "nome")
  @Mapping(target = "usuario.sobrenome", source = "sobrenome")
  @Mapping(target = "usuario.cpf", source = "cpf")
  @Mapping(target = "usuario.telefone", source = "telefone")
  @Mapping(target = "usuario.renda", source = "renda")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "aprovada", ignore = true)
  @Mapping(target = "integrada", ignore = true)
  @Mapping(target = "observacao", ignore = true)
  PropostaEntity convertDtoToPropostaEntity(PropostaRequestDto propostaRequestDto);

  @Mapping(target = "nome", source = "usuario.nome")
  @Mapping(target = "sobrenome", source = "usuario.sobrenome")
  @Mapping(target = "telefone", source = "usuario.telefone")
  @Mapping(target = "cpf", source = "usuario.cpf")
  @Mapping(target = "renda", source = "usuario.renda")
  PropostaResponseDto convertPropostaEntityToDto(PropostaEntity propostaEntity);

  List<PropostaResponseDto> convertListEntitiesToListDtos(List<PropostaEntity> propostaEntities);
}
