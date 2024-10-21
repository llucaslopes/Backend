package com.exercicio.banco.service;

import com.exercicio.banco.model.Conta;
import com.exercicio.banco.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {
    private List<Conta> contas = new ArrayList<>();

    public TransacoesService() {
        contas.add(new Conta("500-1", "Fulano", 1000.0));
        contas.add(new Conta("320-2", "Ciclano", 500.0));
    }

    public Conta encontrarContaPorCodigo(String codigo) {
        return contas.stream()
                .filter(conta -> conta.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public Transacao realizarTransacao(String origemCodigo, String destinoCodigo, Double valor) {
        Conta origem = encontrarContaPorCodigo(origemCodigo);
        Conta destino = encontrarContaPorCodigo(destinoCodigo);

        if (origem != null && destino != null && origem.getSaldo() >= valor) {
            origem.setSaldo(origem.getSaldo() - valor);
            destino.setSaldo(destino.getSaldo() + valor);
            return new Transacao(origem, destino, valor);
        }
        return null;
    }
}
