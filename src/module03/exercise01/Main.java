package module03.exercise01;

import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Depósito inicial: ");
        double initial = scanner.nextDouble();

        BankAccount account = new BankAccount(initial);

        int option;
            do {
                System.out.println("===Escolha uma das opções===");
                System.out.println("1 - Consultar saldo");
                System.out.println("2 - Consultar cheque especial");
                System.out.println("3 - Depositar dinheiro");
                System.out.println("4 - Sacar dinheiro");
                System.out.println("5 - Pagar um boleto");
                System.out.println("6 - Verificar uso de cheque especial");
                System.out.println("0 - Sair");

                option = scanner.nextInt();

                switch (option) {
                    case 1 -> System.out.printf("Saldo: R$ %.2f%n", account.getBalance());
                    case 2 -> System.out.printf("Cheque especial (limite): R$ %.2f%n", account.getOverdraftLimit());
                    case 3 -> setDeposit(account);
                    case 4 -> setWithdraw(account);
                    case 5 -> setPayBill(account);
                    case 6 -> checkOverdraft(account);
                    case 0 -> System.exit(0);
                    default -> System.out.println("Opção inválida");
                }
        } while (true);

    }

    private static void setDeposit(BankAccount account) {
        System.out.println("Qual valor deseja depositar?");
        var amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private static void setWithdraw(BankAccount account) {
        System.out.println("Qual valor deseja sacar?");
        var amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private static void setPayBill(BankAccount account) {
        System.out.println("Qual é o valor do boleto que deseja pagar?");
        var amount = scanner.nextDouble();
        account.payBill(amount);
    }

    private static void checkOverdraft(BankAccount account) {
        var isUsingOverdraft = account.isUsingOverdraft();
        if (isUsingOverdraft) {
            System.out.println("Conta está usando cheque especial");
        } else {
            System.out.println("Conta NÃO está usando cheque especial");
        }
    }
}
