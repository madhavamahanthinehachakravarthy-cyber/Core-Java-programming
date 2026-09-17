// Digital Payment Wallet System

// PaymentService Interface
interface PaymentService {

    void pay(String receiverUPI, double amount)
            throws InvalidUPIException,
                   InvalidAmountException,
                   InsufficientBalanceException;

    void checkBalance();
}


// Custom Exception 1
class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}


// Custom Exception 2
class InvalidUPIException extends Exception {

    public InvalidUPIException(String message) {
        super(message);
    }
}


// Custom Exception 3
class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}


// Wallet Class
class Wallet {

    // Encapsulation - private data members
    private String userName;
    private String mobileNumber;
    private String upiId;
    private double balance;


    // Constructor
    public Wallet(String userName, String mobileNumber, String upiId) {

        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.upiId = upiId;
        this.balance = 0.0;
    }


    // Add money to wallet
    public void addMoney(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Amount must be greater than zero."
            );
        }

        balance = balance + amount;

        System.out.println("Money Added: Rs." + amount);
    }


    // Get wallet balance
    public double getBalance() {

        return balance;
    }


    // Deduct money from wallet
    public void deductMoney(double amount) {

        balance = balance - amount;
    }


    // Display wallet details
    public void displayWalletDetails() {

        System.out.println("\n========== WALLET DETAILS ==========");

        System.out.println("User Name     : " + userName);

        System.out.println("Mobile Number : " + mobileNumber);

        System.out.println("UPI ID        : " + upiId);

        System.out.printf(
                "Balance       : Rs.%.2f%n",
                balance
        );

        System.out.println("====================================");
    }
}


// UPI Payment Class
class UPIPayment implements PaymentService {

    private Wallet wallet;


    // Constructor
    public UPIPayment(Wallet wallet) {

        this.wallet = wallet;
    }


    // Validate UPI ID
    private boolean validateUPI(String upi) {

        if (upi == null || upi.trim().isEmpty()) {

            return false;
        }

        int atSymbol = upi.indexOf('@');

        return atSymbol > 0
                && atSymbol < upi.length() - 1
                && atSymbol == upi.lastIndexOf('@');
    }


    // Make UPI payment
    @Override
    public void pay(
            String receiverUPI,
            double amount
    )
            throws InvalidUPIException,
                   InvalidAmountException,
                   InsufficientBalanceException {


        // Validate UPI
        if (!validateUPI(receiverUPI)) {

            throw new InvalidUPIException(
                    "Invalid UPI ID: " + receiverUPI
            );
        }


        // Validate amount
        if (amount <= 0) {

            throw new InvalidAmountException(
                    "Payment amount must be greater than zero."
            );
        }


        // Check balance
        if (amount > wallet.getBalance()) {

            throw new InsufficientBalanceException(
                    "Insufficient wallet balance."
            );
        }


        // Deduct payment amount
        wallet.deductMoney(amount);


        // Payment success
        System.out.println(
                "\n---------- PAYMENT SUCCESSFUL ----------"
        );

        System.out.println(
                "Receiver UPI : " + receiverUPI
        );

        System.out.println(
                "Amount Paid   : Rs." + amount
        );

        System.out.printf(
                "Remaining Bal : Rs.%.2f%n",
                wallet.getBalance()
        );

        System.out.println(
                "----------------------------------------"
        );
    }


    // Check balance
    @Override
    public void checkBalance() {

        System.out.printf(
                "Available Wallet Balance: Rs.%.2f%n",
                wallet.getBalance()
        );
    }
}


// Main Class
public class DigitalPaymentSystem {

    public static void main(String[] args) {

        try {

            System.out.println(
                    "===================================="
            );

            System.out.println(
                    "       DIGITAL PAYMENT SYSTEM"
            );

            System.out.println(
                    "===================================="
            );


            // Create Wallet object
            Wallet wallet = new Wallet(
                    "Neha",
                    "9876543210",
                    "neha@upi"
            );


            // Create PaymentService object
            PaymentService payment =
                    new UPIPayment(wallet);


            // Add money
            System.out.println(
                    "\nAdding money to wallet..."
            );

            wallet.addMoney(5000);


            // Check balance
            System.out.println(
                    "\nChecking wallet balance..."
            );

            payment.checkBalance();


            // Make payment
            System.out.println(
                    "\nProcessing UPI payment..."
            );

            payment.pay(
                    "friend@upi",
                    1500
            );


            // Display final details
            System.out.println(
                    "\nFinal Wallet Details:"
            );

            wallet.displayWalletDetails();


        }
        catch (InvalidUPIException e) {

            System.out.println(
                    "\nTransaction Failed!"
            );

            System.out.println(
                    "Reason: " + e.getMessage()
            );
        }


        catch (InvalidAmountException e) {

            System.out.println(
                    "\nTransaction Failed!"
            );

            System.out.println(
                    "Reason: " + e.getMessage()
            );
        }


        catch (InsufficientBalanceException e) {

            System.out.println(
                    "\nTransaction Failed!"
            );

            System.out.println(
                    "Reason: " + e.getMessage()
            );
        }


        finally {

            System.out.println(
                    "\nTransaction process completed."
            );

            System.out.println(
                    "Thank you for using Digital Payment System."
            );
        }
    }
}