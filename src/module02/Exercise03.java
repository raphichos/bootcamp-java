package module02;
import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Informe o primeiro número:");
        var number1 = scanner.nextInt();

        int number2;
        do {
            System.out.println("Informe o segundo número (maior que " + number1 + "):");
            number2 = scanner.nextInt();
        } while (number2 < number1);


        System.out.println("Você quer ver números pares ou ímpares?(par/impar)");
        var escolha = scanner.next();

        for (int i = number2; i >= number1; i--) {
            if (escolha.equalsIgnoreCase("par")) {
                if (i % 2 == 0) {
                    System.out.printf("%s \n", i);
                }
            } else if (escolha.equalsIgnoreCase("impar")) {
                if (i % 2 != 0) {
                    System.out.printf("%s \n", i);
                }
            }
        }
    }
}
