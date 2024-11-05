package com.example.gerador_player.service;

import com.example.gerador_player.model.Jogador;
import com.example.gerador_player.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository repository;

    public Jogador salvarJogador(Jogador jogador) {
        return repository.save(jogador);
    }

    public List<Jogador> listarJogadores() {
        return repository.findAll();
    }
}
