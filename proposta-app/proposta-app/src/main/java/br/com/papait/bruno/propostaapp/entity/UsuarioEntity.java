package br.com.papait.bruno.propostaapp.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class UsuarioEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String sobrenome;
  private String cpf;
  private String telefone;
  private BigDecimal renda;
  @OneToOne(mappedBy = "usuario")
  private PropostaEntity proposta;
}
