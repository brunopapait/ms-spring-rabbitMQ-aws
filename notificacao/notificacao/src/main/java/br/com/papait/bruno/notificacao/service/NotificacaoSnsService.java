package br.com.papait.bruno.notificacao.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoSnsService {

  private final AmazonSNS amazonSNS;

  public void enviarNotificacao(final String telefone, final String mensagem) {
    try {
      var publishRequest = new PublishRequest()
          .withMessage(mensagem)
          .withPhoneNumber(telefone);

      this.amazonSNS.publish(publishRequest);
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao enviar notificação", ex);
    }
  }
}
