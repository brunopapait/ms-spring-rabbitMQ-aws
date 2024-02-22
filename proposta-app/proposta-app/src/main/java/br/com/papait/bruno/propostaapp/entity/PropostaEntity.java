package br.com.papait.bruno.propostaapp.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class PropostaEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal valorSolicitado;
  private int prazoPagamento;
  private Boolean aprovada;
  private boolean integrada;
  private String observacao;

  @OneToOne
  @JoinColumn(name = "id_usuario")
  private UsuarioEntity usuario;
}
