package module07.tutorial3;

import java.util.Scanner;

//Enums

public class Main {


    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var option = -1;
        while (option != 5){
            System.out.println("Escolha uma opção pelo número");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtração");
            System.out.println("3 - Multiplicaçåo");
            System.out.println("4 - Divisåo");
            System.out.println("5 - Sair");
            option = scanner.nextInt();

            if (option > 5 || option < 1){
                System.out.println("Selecione uma opçåo válida");
                continue;
            }

            if (option == 5) break;

            var selectedOption = OperationEnum.values()[option - 1];

            System.out.println("Informe o primeiro valor:");
            var value1 = scanner.nextInt();
            System.out.println("Informe o segundo valor:");
            var value2 = scanner.nextInt();

            var result = selectedOption.getCalculate().apply(value1, value2);

            System.out.printf("%s %s %s = %s \n", value1, selectedOption.getSymbol(), value2, result);

        }

    }

}
