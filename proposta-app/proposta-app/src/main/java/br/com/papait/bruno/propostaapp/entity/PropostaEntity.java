package br.com.papait.bruno.propostaapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
