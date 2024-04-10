package br.com.papait.bruno.notificacao.service;

import org.springframework.stereotype.Service;

@Service
public class NotificacaoSnsService {

  public void enviarNotificacao(String mensagem) {
    System.out.println("Enviando notificação: " + mensagem);
  }
}
