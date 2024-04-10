package br.com.papait.bruno.notificacao.listener;

import br.com.papait.bruno.notificacao.constante.Mensagem;
import br.com.papait.bruno.notificacao.domain.Proposta;
import br.com.papait.bruno.notificacao.service.NotificacaoSnsService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaPendenteListener {

  private final NotificacaoSnsService notificacaoSnsService;

  public PropostaPendenteListener(NotificacaoSnsService notificacaoSnsService) {
    this.notificacaoSnsService = notificacaoSnsService;
  }

  @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
  public void propostaPendente(Proposta proposta) {
    var mensagem = String.format(Mensagem.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
    this.notificacaoSnsService.enviarNotificacao(mensagem);
  }
}
