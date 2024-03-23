package br.com.papait.bruno.propostaapp.repository;

import br.com.papait.bruno.propostaapp.entity.PropostaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends JpaRepository<PropostaEntity, Long> {
  List<PropostaEntity> findAllByIntegradaIsFalse();
}
