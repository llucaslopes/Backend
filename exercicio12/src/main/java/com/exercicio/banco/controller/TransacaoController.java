package com.exercicio.banco.controller;

import com.exercicio.banco.dto.ContaDTO;
import com.exercicio.banco.dto.TransacaoRequestDTO;
import com.exercicio.banco.dto.TransacaoResponseDTO;
import com.exercicio.banco.mapper.ContaMapper;
import com.exercicio.banco.model.Transacao;
import com.exercicio.banco.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> gerarTransacao(@RequestBody TransacaoRequestDTO transacaoRequest) {
        Transacao transacao = transacoesService.realizarTransacao(
                transacaoRequest.origem(),
                transacaoRequest.destino(),
                transacaoRequest.valor());

        if (transacao != null) {
            ContaDTO origemDTO = ContaMapper.toContaDTO(transacao.getOrigem());
            ContaDTO destinoDTO = ContaMapper.toContaDTO(transacao.getDestino());
            TransacaoResponseDTO responseDTO = new TransacaoResponseDTO(origemDTO, destinoDTO, transacao.getValor());
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
