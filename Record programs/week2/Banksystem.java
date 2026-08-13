mport java.util.Scanner;

//Base class for all accounts
class Account {

    int accNo; // account number
    double balance; // money in account
    String type; // savings or current

    Account(int no, double bal, String t) {
        accNo = no;
        balance = bal;
        type = t;
    }

    // deposit money
    void deposit(double amt) {
        balance += amt;

        System.out.println("Deposited: " + amt);
        System.out.println("Balance: " + balance);
    }

    // withdraw money
    void withdraw(double amt) {

        if (amt <= balance) {
            balance -= amt;

            System.out.println("Withdrawn: " + amt);
            System.out.println("Balance: " + balance);

        } else {
            System.out.println("Not enough balance!");
        }
    }

    // transfer money to another account
    void transfer(Account other, double amt) {

        if (amt <= balance) {
            balance -= amt;
            other.balance += amt;

            System.out.println("Transfer done!");

        } else {
            System.out.println("Transfer failed!");
        }
    }

    // show account info
    void show() {
        System.out.println("Acc No: " + accNo);
        System.out.println("Type : " + type);
        System.out.println("Bal : " + balance);
    }
}

//Savings account class
class SavingsAccount extends Account {

    double rate; // interest rate

    SavingsAccount(int no, double bal, double r) {
        super(no, bal, "Savings");
        rate = r;
    }

    void calcInterest() {
        double interest = balance * rate / 100;

        System.out.println("Interest: " + interest);
    }
}

//Current account class
class CurrentAccount extends Account {

    double limit; // overdraft limit

    CurrentAccount(int no, double bal, double l) {
        super(no, bal, "Current");
        limit = l;
    }

    // overriding withdraw
    @Override
    void withdraw(double amt) {

        if (amt <= balance + limit) {
            balance -= amt;

            System.out.println("Withdraw ok. Balance: " + balance);

        } else {
            System.out.println("Overdraft limit crossed!");
        }
    }
}

//main class
public class Banksystem {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            SavingsAccount sAcc =
                    new SavingsAccount(101, 5000, 5);
            
            CurrentAccount cAcc =
                    new CurrentAccount(201, 3000, 2000);
            
            int ch;
            
            do {
                
                System.out.println("\n--- Bank Menu ---");
                System.out.println("1. Deposit (Savings)");
                System.out.println("2. Withdraw (Savings)");
                System.out.println("3. Interest (Savings)");
                System.out.println("4. Withdraw (Current)");
                System.out.println("5. Transfer Savings -> Current");
                System.out.println("6. Show Accounts");
                System.out.println("7. Exit");
                
                System.out.print("Choice: ");
                ch = sc.nextInt();
                
                switch (ch) {
                    
                    case 1 -> {
                        System.out.print("Amount: ");
                        sAcc.deposit(sc.nextDouble());
                    }
                    
                    case 2 -> {
                        System.out.print("Amount: ");
                        sAcc.withdraw(sc.nextDouble());
                    }
                    
                    case 3 -> sAcc.calcInterest();
                    
                    case 4 -> {
                        System.out.print("Amount: ");
                        cAcc.withdraw(sc.nextDouble());
                    }
                    
                    case 5 -> {
                        System.out.print("Amount: ");
                        sAcc.transfer(cAcc, sc.nextDouble());
                    }
                    
                    case 6 -> {
                        System.out.println("Savings:");
                        sAcc.show();
                        
                        System.out.println("Current:");
                        cAcc.show();
                    }
                    
                    case 7 -> System.out.println("Bye!");
                    
                    default -> System.out.println("Wrong choice!");
                }
                
            } while (ch != 7);
        }
    }
}