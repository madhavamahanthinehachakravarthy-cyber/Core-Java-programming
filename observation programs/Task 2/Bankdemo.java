class BankAccount {

    private final int number;
    private final String holder;
    protected double balance;

    // Constructor
    BankAccount(int number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    // Deposit money
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn Rs." + amount);
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }

    // Transfer money
    void transfer(BankAccount target, double amount) {
        if (withdraw(amount)) {
            target.deposit(amount);
            System.out.println("Transferred Rs." + amount
                    + " to Account " + target.number);
        } else {
            System.out.println("Transfer failed.");
        }
    }

    // Display account details
    void displayDetails() {
        System.out.println("Account Number : " + number);
        System.out.println("Holder Name    : " + holder);
        System.out.printf("Balance        : Rs.%.2f%n", balance);
    }
}


// Savings Account
class SavingsAccount extends BankAccount {

    private final double rate;

    // Constructor
    SavingsAccount(int number, String holder,
                   double balance, double rate) {
        super(number, holder, balance);
        this.rate = rate;
    }

    // Calculate interest
    double calculateInterest() {
        return balance * rate / 100;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type   : Savings");
        System.out.println("Interest Rate  : " + rate + "%");
        System.out.printf("Interest       : Rs.%.2f%n",
                calculateInterest());
    }
}


// Current Account
class CurrentAccount extends BankAccount {

    private final double limit;

    // Constructor
    CurrentAccount(int number, String holder,
                   double balance, double limit) {
        super(number, holder, balance);
        this.limit = limit;
    }

    // Overriding withdraw method
    @Override
    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance + limit) {
            balance = balance - amount;
            System.out.println("Withdrawn Rs." + amount);
            return true;
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
            return false;
        }
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type   : Current");
        System.out.printf("Overdraft Limit: Rs.%.2f%n", limit);
    }
}


// Main class
public class Bankdemo {

    public static void main(String[] args) {

        // Creating objects
        SavingsAccount savings =
                new SavingsAccount(101, "Rahul", 10000, 5.0);

        CurrentAccount current =
                new CurrentAccount(201, "Priya", 15000, 5000);


        // Savings Account
        System.out.println("===== SAVINGS ACCOUNT =====");
        savings.displayDetails();

        System.out.println("\nDepositing Rs.2000...");
        savings.deposit(2000);

        System.out.println("\nWithdrawing Rs.1500...");
        savings.withdraw(1500);

        System.out.println("\n===== AFTER TRANSACTIONS =====");
        savings.displayDetails();


        // Current Account
        System.out.println("\n===== CURRENT ACCOUNT =====");
        current.displayDetails();

        System.out.println("\nWithdrawing Rs.18000...");
        current.withdraw(18000);

        System.out.println("\n===== AFTER WITHDRAWAL =====");
        current.displayDetails();


        // Fund Transfer
        System.out.println("\n===== FUND TRANSFER =====");
        System.out.println(
                "Transferring Rs.2000 from Savings to Current..."
        );

        savings.transfer(current, 2000);


        // Final Details
        System.out.println("\n===== FINAL ACCOUNT DETAILS =====");

        System.out.println("\nSavings Account:");
        savings.displayDetails();

        System.out.println("\nCurrent Account:");
        current.displayDetails();


        // Final balances
        System.out.println("\n===== FINAL BALANCES =====");

        System.out.printf("Savings Balance : Rs.%.2f%n",
                savings.balance);

        System.out.printf("Current Balance : Rs.%.2f%n",
                current.balance);
    }
}