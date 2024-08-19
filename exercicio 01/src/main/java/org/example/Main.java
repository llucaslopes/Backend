package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        String[] listaFilmes = {"Homens de preto","Arrival","Shewk","Gladiador"};

        Scanner leitor = new Scanner(System.in);

        System.out.println("Pergunta 1: Que ambientação você prefere?");
        System.out.println("1. Sci-fi");
        System.out.println("2. Medieval");
        Integer ambientacao = leitor.nextInt();

        System.out.println("Pergunta 2: Que gênero você prefere?");
        System.out.println("1. Comédia");
        System.out.println("2. Drama");
        Integer genero = leitor.nextInt();


        String filmesRecomendados = listaFilmes[ambientacao + genero -2];

        System.out.println(String.format("Filmes recomendados: %s", filmesRecomendados));

        /*
        if (ambientacao == 1 && genero == 1)System.out.println("Homens de preto");
        if (ambientacao == 1 && genero == 2)System.out.println("Arrival");
        if (ambientacao == 2 && genero == 1)System.out.println("Shewk");
        if (ambientacao == 2 && genero == 2)System.out.println("Gladiador");
        else System.out.println("aaaa");

       */



    }
}


