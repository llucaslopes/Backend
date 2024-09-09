package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private List<Filme> filmesDisponiveis = new ArrayList<>();
    private List<Ingresso> ingressosVendidos = new ArrayList<>();
    private List<String> assentosDisponiveis = new ArrayList<>();

    public Cinema() {
        // Adiciona assentos de A1 a F5
        for (char fileira = 'A'; fileira <= 'F'; fileira++) {
            for (int numero = 1; numero <= 5; numero++) {
                assentosDisponiveis.add(fileira + String.valueOf(numero));
            }
        }
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilme(String nomeFilme) {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nomeFilme)) {
                return filme;
            }
        }
        return null;
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento) throws Exception {
        if (!assentosDisponiveis.contains(assento)) {
            throw new Exception("O ingresso não pode ser vendido pois o assento não está mais disponível!");
        }

        if (cliente.getIdade() < filme.getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        Ingresso ingresso = new Ingresso(cliente, filme, assento);
        ingressosVendidos.add(ingresso);
        assentosDisponiveis.remove(assento);

        System.out.println(ingresso);
    }
}

