package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        cinema.adicionarFilme(new Filme("Homem Aranha", 25.0, 12));
        cinema.adicionarFilme(new Filme("Vingadores", 30.0, 14));
        cinema.adicionarFilme(new Filme("Frozen", 20.0, 6));
        cinema.adicionarFilme(new Filme("It: A Coisa", 20.0, 18));
        cinema.adicionarFilme(new Filme("Harry Potter", 25.0, 10));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {

                System.out.println("Que filme você deseja assistir?");
                String nomeFilme = scanner.nextLine();
                Filme filme = cinema.buscarFilme(nomeFilme);
                if (filme == null) {
                    System.out.println("Filme não encontrado!");
                    continue;
                }

                // Entrada do assento
                System.out.println("Qual assento você deseja?");
                String assento = scanner.nextLine();

                // Entrada do cliente
                System.out.println("Qual o seu nome?");
                String nomeCliente = scanner.nextLine();

                System.out.println("Qual a sua idade?");
                int idadeCliente = scanner.nextInt();
                scanner.nextLine(); // Consumir o enter

                Cliente cliente = new Cliente(nomeCliente, idadeCliente);

                // Vender ingresso
                cinema.venderIngresso(cliente, filme, assento);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Deseja realizar outra compra? (s/n)");
            String resposta = scanner.nextLine();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }

        scanner.close();
    }
}