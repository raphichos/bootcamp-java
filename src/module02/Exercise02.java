package module02;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Informe sua altura (em metros):");
        var altura = scanner.nextDouble();

        // If user typed centimeters (e.g., 173), convert to meters
        if (altura > 3) { // no one is > 3 meters tall
            altura = altura / 100;
        }

        System.out.println("Informe seu peso (em kg):");
        var peso = scanner.nextDouble();

        var imc = peso / (altura * altura);

        System.out.printf("IMC = %.2f \n", imc);

        if (imc <= 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc <= 24.9) {
            System.out.println("Peso ideal");
        } else if (imc <= 29.9) {
            System.out.println("Levemente acima do peso");
        } else if (imc <= 34.9) {
            System.out.println("Obesidade Grau I");
        } else if (imc <= 39.9) {
            System.out.println("Obesidade Grau II (Severa)");
        } else {
            System.out.println("Obesidade III (Mórbida)");
        }
    }
}
