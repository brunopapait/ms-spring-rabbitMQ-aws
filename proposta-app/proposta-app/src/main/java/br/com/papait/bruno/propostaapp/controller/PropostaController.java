package br.com.papait.bruno.propostaapp.controller;

import br.com.papait.bruno.propostaapp.dto.PropostaRequestDto;
import br.com.papait.bruno.propostaapp.dto.PropostaResponseDto;
import br.com.papait.bruno.propostaapp.service.PropostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposta")
@RequiredArgsConstructor
public class PropostaController {

  private final PropostaService propostaService;

  @PostMapping
  public ResponseEntity<PropostaResponseDto> criar(
      @RequestBody PropostaRequestDto propostaRequestDto) {
    return ResponseEntity.ok().body(this.propostaService.criarProposta(propostaRequestDto));
  }
}
