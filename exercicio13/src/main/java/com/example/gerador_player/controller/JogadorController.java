package com.example.gerador_player.controller;

import com.example.gerador_player.dto.JogadorDTO;
import com.example.gerador_player.mapper.JogadorMapper;
import com.example.gerador_player.model.Jogador;
import com.example.gerador_player.service.JogadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    private JogadorService service;

    @PostMapping
    public ResponseEntity<Jogador> criarJogador(@RequestBody @Valid JogadorDTO jogadorDTO) {
        Jogador jogador = JogadorMapper.toEntity(jogadorDTO);
        Jogador jogadorSalvo = service.salvarJogador(jogador);
        return new ResponseEntity<>(jogadorSalvo, HttpStatus.CREATED);
    }

    @GetMapping
    public List<JogadorDTO> listarJogadores() {
        return service.listarJogadores().stream()
                .map(JogadorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
