package com.exercicio.banco.model;

public class Conta {
    private String codigo;
    private String cliente;
    private Double saldo;

    public Conta(String codigo, String cliente, Double saldo) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
