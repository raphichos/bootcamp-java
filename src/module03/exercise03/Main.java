package module03.exercise03;

import java.util.Scanner;

public class Main {

    // WHY: single scanner for the whole app (avoid creating many); static to use inside static main
    private final static Scanner scanner = new Scanner(System.in);

    // WHY: single PetMachine instance to hold state across menu actions
    private final static PetMachine petMachine = new PetMachine();

    public static void main(String[] args) {
        // WHY: read tokens until newline so next() grabs the full line name; avoids leftover spaces
        scanner.useDelimiter("\\n");
        var option = -1;

        // WHY: interactive program—loop forever until user chooses 0 (System.exit)
        do {
            System.out.println("===Escolha uma das opções===");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a máquina com água");
            System.out.println("3 - Abastecer a máquina com shampoo");
            System.out.println("4 - Verificar água da máquina");
            System.out.println("5 - Verificar shampoo da máquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar a máquina");
            System.out.println("0 - Sair");
            option = scanner.nextInt();

            // WHY: dispatch to the correct action; arrow switch keeps it concise
            switch (option){
                case 1 -> petMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setShampoo();
                case 4 -> verifyWater();
                case 5 -> verifyShampoo();
                case 6 -> checkIfHasPetInMachine();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.wash();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida");
            }

        }while (true); // WHY: menu loop lives until exit option is chosen
    }

    // --- Helpers to keep switch small and add user feedback ---
    private static void setWater(){
        System.out.println("Tentando colocar água na máquina");
        petMachine.addWater();
    }

    private static void setShampoo(){
        System.out.println("Tentando colocar shampoo na máquina");
        petMachine.addShampoo();
    }

    private static void verifyWater() {
        var amount = petMachine.getWater();
        System.out.println("A máquina está no momento com " + amount + " litros(s) de água");
    }

    private static void verifyShampoo() {
        var amount = petMachine.getShampoo();
        System.out.println("A máquina está no momento com " + amount + " litros(s) de shampoo");
    }

    private static void checkIfHasPetInMachine() {
        var hasPet = petMachine.hasPet();
        // WHY: ternary prints one of two messages based on current state
        System.out.println(hasPet ? "Tem pet na máquina" : "Não tem pet na máquina");
    }


    public static void setPetInPetMachine(){
        var name = "";
        // WHY: input validation—loop until a non-empty pet name is provided
        while (name == null || name.isEmpty()){
            System.out.println("Informe o nome do pet");
            name = scanner.next();
        }
        var pet = new Pet(name); // WHY: create domain object with initial defaults
        petMachine.setPet(pet); // WHY: delegate rule checks to machine (encapsulation)
    }


}
