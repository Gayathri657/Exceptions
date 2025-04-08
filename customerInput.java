import java.util.Scanner;

class customException extends Exception {
    customException(String msg) {
        super(msg);
    }
}

class BankTransactionSystem {

    int balance;
    String accountName;
    String password;
    Scanner sc = new Scanner(System.in);

    BankTransactionSystem(String accountName, String password, int balance) {
        this.accountName = accountName;
        this.password = password;
        this.balance = balance;
    }

    public boolean verify(String Name, String Password) throws customException {
        if (Name.equals(accountName) && Password.equals(password)) {
            return true;
        } else {
            throw new customException("Invalid credentials...please try again");
        }

    }

    public void deposit(int amount) {
        balance = balance + amount;
        System.out.println("your current balance is" + " " + balance);

    }

    public boolean withdraw(int amount) throws customException {
        if (balance > 1000) {
            balance = balance - amount;
            System.out.println("After the withdrawal the amount in your account is" + balance);
            return true;
        } else {
            throw new customException("You have less balance in your account. Can't withdraw the amount");
        }

    }

    public void Input() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.println("Enter username");
            String cusName = sc.nextLine();
            System.out.println("Enter password");
            String cuspassword = sc.nextLine();

            try {
                boolean validation = verify(cusName, cuspassword);
                if (validation) {
                    System.out.println("Login Sucessfully");
                    break;
                }
            } catch (customException e) {
                attempts++;
                System.out.println(e.getMessage());
                if (attempts == 3) {
                    System.out.println("You have reached the maximum number of attempts.");
                    break;
                }
            }

            while (true) {
                System.out.println("Enter 1 for depositing and 2 for withdrawing");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    System.out.println("Enter the amount to be desposited");
                    int amount = sc.nextInt();
                    sc.nextLine();
                    deposit(amount);
                    break;
                } else if (choice == 2) {
                    System.out.println("Enter the amount to withdraw");
                    int amount = sc.nextInt();
                    sc.nextLine();
                    try {
                        boolean success = withdraw(amount);
                        if (success)
                            break;
                    } catch (customException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }
        }
    }
}

public class customerInput {
    public static void main(String[] args) {

        BankTransactionSystem bt = new BankTransactionSystem("Gayathri", "ganesh@5", 1000);
        bt.Input();

    }
}
