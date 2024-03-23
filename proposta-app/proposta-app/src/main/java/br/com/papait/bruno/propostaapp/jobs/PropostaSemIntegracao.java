package br.com.papait.bruno.propostaapp.jobs;

import br.com.papait.bruno.propostaapp.entity.PropostaEntity;
import br.com.papait.bruno.propostaapp.repository.PropostaRepository;
import br.com.papait.bruno.propostaapp.service.NotificacaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class PropostaSemIntegracao {

  private final PropostaRepository propostaRepository;
  private final NotificacaoService notificacaoService;
  private final String exchange;

  public PropostaSemIntegracao(
      PropostaRepository propostaRepository,
      NotificacaoService notificacaoService,
      @Value("${rabbitmq.propostapendente.exchange}") String exchange
  ) {
    this.propostaRepository = propostaRepository;
    this.notificacaoService = notificacaoService;
    this.exchange = exchange;
  }

  private final Logger logger = LoggerFactory.getLogger(PropostaSemIntegracao.class);

  @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
  public void buscarPropostasSemIntegracao() {
    this.propostaRepository.findAllByIntegradaIsFalse()
        .forEach(item -> {
          try {
            this.notificacaoService.enviarNotificacao(item, exchange);
            this.atualizarProposta(item);
          } catch (RuntimeException ex) {
            logger.error(ex.getMessage());
          }
        });
  }

  private void atualizarProposta(final PropostaEntity propostaEntity) {
    propostaEntity.setIntegrada(true);
    this.propostaRepository.save(propostaEntity);
  }
}
