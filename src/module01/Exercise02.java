package module01;
import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Informe o valor do lado do quadrado:");
        var lado = scanner.nextInt();

        var area = lado * lado;

        System.out.printf("A área do quadrado é %s \n", area);

        scanner.close();
    }
}
