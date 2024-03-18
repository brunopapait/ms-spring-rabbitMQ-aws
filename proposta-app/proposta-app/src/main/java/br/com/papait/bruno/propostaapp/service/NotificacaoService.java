package br.com.papait.bruno.propostaapp.service;

import br.com.papait.bruno.propostaapp.dto.PropostaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

  private final RabbitTemplate rabbitTemplate;

  public void enviarNotificacao(final PropostaResponseDto propostaResponseDto, final String exchange) {
    rabbitTemplate.convertAndSend(exchange, "", propostaResponseDto);
  }
}
