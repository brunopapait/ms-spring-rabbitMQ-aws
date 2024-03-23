package br.com.papait.bruno.propostaapp.service;

import br.com.papait.bruno.propostaapp.entity.PropostaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

  private final RabbitTemplate rabbitTemplate;

  public void enviarNotificacao(final PropostaEntity propostaResponseDto, final String exchange) {
    rabbitTemplate.convertAndSend(exchange, "", propostaResponseDto);
  }
}
