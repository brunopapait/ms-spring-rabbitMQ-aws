package br.com.papait.bruno.propostaapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "id_usuario")
  @JsonManagedReference
  private UsuarioEntity usuario;
}
