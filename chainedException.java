class transactionFailed extends Exception {
    transactionFailed(String msg, Throwable cause) {
        super(msg, cause);
    }
}

class InsufficientFunds extends Exception {
    InsufficientFunds(String msg) {
        super(msg);
    }
}

public class chainedException {
    int balance = 500;

    chainedException(int balance) {
        this.balance = balance;
    }

    public void withdrawal(int amount) throws transactionFailed {

        if (amount >= balance) {
            try {
                throw new InsufficientFunds("Not enough balance");
            } catch (InsufficientFunds e) {
                throw new transactionFailed("Unable to process the withdrawal", e);
            }
        }
        balance -= amount;
        System.out.println("Withdrawal is successful. Remaining balance is: " + balance);
    }

    public static void main(String[] args) {
        chainedException ce = new chainedException(1000);
        try {
            ce.withdrawal(2000);
        } catch (transactionFailed e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getMessage());
        }
    }
}
