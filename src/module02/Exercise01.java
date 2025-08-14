package module02;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe um número:");
        var number = scanner.nextInt();
        System.out.println("Multiplication Table for " + number);

        for (int i = 1; i <= 10; i++) {
            var result = number * i;
            System.out.println(number + " * " + i + " = " + result);
        }
    }
}
