package module03.exercise03;

public class PetMachine {

    private boolean clean = true; // WHY: machine starts ready for use

    private int water = 30; // WHY: initial resources (max capacity here)

    private int shampoo = 10;

    private Pet pet; // WHY: current occupant; null means empty

    public void takeAShower(){
        // WHY: cannot bathe without a pet present
        if (this.pet == null){
            System.out.println("Coloque o pet na máquina para iniciar o banho");
            return;
        }

        // WHY: bathing consumes resources and cleans the pet
        this.water -= 10;
        this.shampoo -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " está limpo");
    }

    public void addWater(){
        // WHY: enforce capacity limit; avoid overflow beyond 30
        if (water == 30){
            System.out.println("A capacidade de água da máquina está no máximo");
            return;
        }

        water += 2;
    }

    public void addShampoo(){
        // WHY: enforce capacity limit; avoid overflow beyond 10
        if (shampoo == 10){
            System.out.println("A capacidade de shampoo da máquina está no máximo");
            return;
        }

        shampoo += 2;
    }

    public int getWater() {
        return water;
    }

    public int getShampoo() {
        return shampoo;
    }

    public boolean hasPet(){
        return pet != null; // WHY: convenience predicate for UI
    }

    public void setPet(Pet pet) {
        // WHY: hygiene rule—machine must be clean before inserting a pet
        if (!this.clean){
            System.out.println("A máquina está suja, para colocar o pet é necessário limpar-la");
            return;
        }
        // WHY: only one pet at a time
        if (hasPet()){
            System.out.println("O pet " + this.pet.getName() + " está na máquina nesse momento");
            return;
        }

        this.pet = pet;
        System.out.println("O pet " + pet.getName() + " foi colocado ná maquina");
    }

    public void removePet(){
        // WHY (design): machine cleanliness mirrors the leaving pet's state
        this.clean = this.pet.isClean();
        System.out.println("O pet " + this.pet.getName() + " foi tirado da máquina");
        this.pet = null;
    }

    public void wash(){
        // WHY: cleaning the machine itself consumes resources and resets cleanliness
        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("A máquina foi limpa");
    }
}
