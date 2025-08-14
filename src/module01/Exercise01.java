package module01;
import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Informe o nome da primeira pessoa:");
        var name1 = scanner.nextLine();

        System.out.println("Informe a idade de " + name1 + ":");
        var age1 = scanner.nextInt();

        scanner.nextLine(); // clear buffer

        System.out.println("Informe o nome da segunda pessoa:");
        var name2 = scanner.nextLine();

        System.out.println("Informe a idade de " + name2 + ":");
        var age2 = scanner.nextInt();

        var ageDifference = Math.abs(age1 - age2);

        System.out.printf("A diferença de idade entre %s e %s é %s! \n",
                name1, name2, ageDifference);

        scanner.close();
    }
}
