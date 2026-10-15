import java.util.*;

abstract class Payment {
    protected double amount;
    public Payment(double amount) {
        this.amount = amount;
    }
    public abstract double calculateAdjustedAmount();
}

class Card extends Payment {
    public Card(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.02; // 2% fee[cite: 1]
    }
}

class Wallet extends Payment {
    public Wallet(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() {
        return amount * 1.01; // 1% fee[cite: 1]
    }
}

class BankTransfer extends Payment {
    public BankTransfer(double amount) { super(amount); }
    @Override
    public double calculateAdjustedAmount() {
        return amount; // 0% fee[cite: 1]
    }
}