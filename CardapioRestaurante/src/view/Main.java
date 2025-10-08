package view;

import controller.GestaoCardapio;

public class Main {
    public static void main(String[] args) {
        GestaoCardapio cardapio = new GestaoCardapio();
        cardapio.menu();  // chama o menu dentro da controller
    }
}
