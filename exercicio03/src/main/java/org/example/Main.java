package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Barco {
    private String nome;
    private int tamanho;

    public Barco(String nome, int tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }
}

class BasePorto {
    private String nome;
    private List<Barco> barcosAtracados;

    public BasePorto(String nome) {
        this.nome = nome;
        this.barcosAtracados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void atracarBarco(Barco barco) {
        barcosAtracados.add(barco);
    }

    public void desatracarBarco(Barco barco) {
        barcosAtracados.remove(barco);
    }

    public List<Barco> getBarcosAtracados() {
        return barcosAtracados;
    }
}

class PortoPequeno extends BasePorto {
    public PortoPequeno(String nome) {
        super(nome);
    }

    @Override
    public void atracarBarco(Barco barco) {
        if (barco.getTamanho() <= 10) {
            super.atracarBarco(barco);
        }
    }
}

class PortoGrande extends BasePorto {
    public PortoGrande(String nome) {
        super(nome);
    }

    @Override
    public void atracarBarco(Barco barco) {
        if (barco.getTamanho() > 10) {
            super.atracarBarco(barco);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Barco[] barcos = {
                new Barco("Barco 1", 2),
                new Barco("Barco 2", 5),
                new Barco("Barco 3", 7),
                new Barco("Barco 4", 12),
                new Barco("Barco 5", 20)
        };

        PortoPequeno portoPequeno = new PortoPequeno("Porto Pequeno");
        PortoGrande portoGrande = new PortoGrande("Porto Grande");

        Scanner scanner = new Scanner(System.in);

        for (Barco barco : barcos) {
            System.out.println("Tentando atracar: " + barco.getNome() + " (Tamanho: " + barco.getTamanho() + ")");
            if (barco.getTamanho() <= 10) {
                portoPequeno.atracarBarco(barco);
                System.out.println(barco.getNome() + " atracado no porto pequeno");
            } else {
                portoGrande.atracarBarco(barco);
                System.out.println(barco.getNome() + " atracado no porto grande");
            }
        }

        System.out.println("\nResumo:");
        System.out.println("Porto Pequeno:");
        for (Barco b : portoPequeno.getBarcosAtracados()) {
            System.out.println(b.getNome() + " (Tamanho: " + b.getTamanho() + ")");
        }

        System.out.println("Porto Grande:");
        for (Barco b : portoGrande.getBarcosAtracados()) {
            System.out.println(b.getNome() + " (Tamanho: " + b.getTamanho() + ")");
        }

        scanner.close();
    }
}
