package module03.exercise01;

public class BankAccount {
    private double balance;
    private final double overdraftLimit;
    private double overdraftUsed;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;

        if (initialBalance <= 500) {
            this.overdraftLimit = 50.0;
        } else {
            this.overdraftLimit = initialBalance * 0.5;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public double getOverdraftLimit() {
        return this.overdraftLimit;
    }

    public void deposit(double amount) {
        this.balance += amount;

        if (this.balance >= 0 && this.overdraftUsed > 0) {
            double fee = this.overdraftUsed * 0.20;
            this.balance -= fee;
            this.overdraftUsed = 0;
        }
    }

    public void withdraw(double amount) {
        if (this.balance + overdraftLimit >= amount){
            this.balance -= amount;
            System.out.println("Withdrawal complete!");
        } else {
            System.out.println("Withdrawal denied. Insufficient balance.");
        }

        if (this.balance < 0) {
            this.overdraftUsed = Math.abs(this.balance); // how much overdraft is used
        } else {
            this.overdraftUsed = 0; // reset if not using overdraft
        }
    }

    public boolean isUsingOverdraft() {
        return this.balance < 0;
    }

    public void payBill(double amount) {
        if (this.balance + overdraftLimit >= amount){
            this.balance -= amount;
            System.out.println("Bill has been paid!");
        } else {
            System.out.println("Bill payment denied.");
        }

        if (this.balance < 0) {
            this.overdraftUsed = Math.abs(this.balance); // how much overdraft is used
        } else {
            this.overdraftUsed = 0; // reset if not using overdraft
        }
    }

}

