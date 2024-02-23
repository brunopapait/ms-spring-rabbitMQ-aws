package br.com.papait.bruno.propostaapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropostaResponseDto {
  private Long id;
  private String nome;
  private String sobrenome;
  private String telefone;
  private String cpf;
  private BigDecimal renda;
  private BigDecimal valorSolicitado;
  private Long prazoPagamento;
  private Boolean aprovado;
  private String observacao;
}
