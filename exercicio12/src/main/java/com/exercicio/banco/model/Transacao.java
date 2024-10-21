package com.exercicio.banco.model;

public class Transacao {
    private Conta origem;
    private Conta destino;
    private Double valor;

    public Transacao(Conta origem, Conta destino, Double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    // Getters
    public Conta getOrigem() {
        return origem;
    }

    public Conta getDestino() {
        return destino;
    }

    public Double getValor() {
        return valor;
    }
}
