package module09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome = scanner.next();
        double preco = scanner.nextDouble();
        String categoria = scanner.next();

        Produto produto = new Produto(nome, preco, categoria);

        System.out.println(produto.formatado());
    }
}