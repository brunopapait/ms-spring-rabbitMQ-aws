package br.com.papait.bruno.propostaapp.controller;

import br.com.papait.bruno.propostaapp.dto.PropostaRequestDto;
import br.com.papait.bruno.propostaapp.dto.PropostaResponseDto;
import br.com.papait.bruno.propostaapp.service.PropostaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/proposta")
@RequiredArgsConstructor
public class PropostaController {

  private final PropostaService propostaService;

  @Transactional
  @PostMapping
  public ResponseEntity<PropostaResponseDto> criar(
      @RequestBody PropostaRequestDto propostaRequestDto) {

    return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(this.propostaService.criarProposta(propostaRequestDto).getId()).toUri())
        .body(this.propostaService.criarProposta(propostaRequestDto));
  }

  @GetMapping
  public ResponseEntity<List<PropostaResponseDto>> obterPropostas() {
    return ResponseEntity.ok(this.propostaService.obterPropostas());
  }
}
