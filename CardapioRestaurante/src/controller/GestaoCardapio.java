package controller;

import java.util.Scanner;
import model.Prato;

public class GestaoCardapio {
    int indice = 0;
    Prato[] pratos = new Prato[50];
    Scanner scanner = new Scanner(System.in);

    public void criar() {
        if (indice >= pratos.length) {
            System.out.println("Limite de pratos atingido!");
            return;
        }

        System.out.println("Digite o ID do prato:");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Digite o código do prato:");
        String codigo = scanner.nextLine();
        System.out.println("Digite o nome do prato:");
        String nome = scanner.nextLine();
        System.out.println("Digite as calorias do prato:");
        int calorias = Integer.parseInt(scanner.nextLine());
        System.out.println("Digite o preço do prato:");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.println("Digite os ingredientes do prato (separar com ';'):");
        String ingredientes = scanner.nextLine();

        pratos[indice] = new Prato(id, codigo, nome, calorias, preco, ingredientes);
        indice++;
        System.out.println("Prato criado com sucesso!");
    }

    public void atualizar() {
        System.out.println("Digite o código do prato que deseja atualizar:");
        String codigo = scanner.nextLine();

        for (int i = 0; i < indice; i++) {
            if (pratos[i] != null && pratos[i].codigo.equals(codigo)) {
                System.out.println("Digite o novo nome do prato:");
                pratos[i].nome = scanner.nextLine();
                System.out.println("Digite as novas calorias do prato:");
                pratos[i].calorias = Integer.parseInt(scanner.nextLine());
                System.out.println("Digite o novo preço do prato:");
                pratos[i].preco = Double.parseDouble(scanner.nextLine());
                System.out.println("Digite os novos ingredientes do prato:");
                pratos[i].ingredientes = scanner.nextLine();
                System.out.println("Prato atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Prato não encontrado.");
    }

    public void excluir() {
        System.out.println("Digite o código do prato que deseja excluir:");
        String codigo = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < indice; i++) {
            if (pratos[i] != null && pratos[i].codigo.equals(codigo)) {
                pratos[i] = null;
                encontrado = true;
            }
        }

        if (encontrado) {
            System.out.println("Prato(s) excluído(s) com sucesso!");
        } else {
            System.out.println("Prato não encontrado.");
        }
    }

    public void exibir() {
        System.out.println("Digite o código do prato que deseja exibir:");
        String codigo = scanner.nextLine();

        for (int i = 0; i < indice; i++) {
            if (pratos[i] != null && pratos[i].codigo.equals(codigo)) {
                System.out.println(pratos[i].toString());
                return;
            }
        }
        System.out.println("Prato não encontrado.");
    }

    public void listar() {
        System.out.println("Lista de pratos:");
        for (int i = 0; i < indice; i++) {
            if (pratos[i] != null) {
                System.out.println(pratos[i].toString());
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("(C)riar   (E)xibir   (R)emover   (A)tualizar   (L)istar   (S)air");

            String textoMaiusculo = scanner.nextLine().toUpperCase();
            char letra = textoMaiusculo.charAt(0);

            switch (letra) {
                case 'C': criar(); break;
                case 'E': exibir(); break;
                case 'R': excluir(); break;
                case 'A': atualizar(); break;
                case 'L': listar(); break;
                case 'S': System.out.println("Saindo do sistema..."); System.exit(0);
                default: System.out.println("Opção inválida!");
            }
        }
    }
}
