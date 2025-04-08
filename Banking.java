import java.util.Scanner;

class customException extends Exception {
    customException(String msg) {
        super(msg);
    }
}

class CustomerDetails {
    private String Name = "Gayathri";
    private String password = "Ganesh@5";
    Scanner sc = new Scanner(System.in);
    String name, Password;

    public void input() {
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        System.out.println("Enter your password: ");
        Password = sc.nextLine();
    }

    public void verify() throws customException {
        if (!Name.equals(name)) {
            throw new customException("Enter valid name");
        } else if (!password.equals(Password)) {
            throw new customException("Enter valid Password");
        }
    }
}

public class Banking {
    public static void main(String[] args) {
        CustomerDetails cd = new CustomerDetails();
        cd.input();
        try {
            cd.verify();
            System.out.println("Login Successfully");
        } catch (customException e) {
            System.out.println(e.getMessage());
            cd.input();
            try {
                cd.verify();
                System.out.println("Login Successfully");
            } catch (customException fe) {
                System.out.println(fe.getMessage());
                cd.input();
                try {
                    cd.verify();
                    System.out.println("Login Successfully");
                } catch (customException se) {
                    System.out.println("We gave you enough chances....Blocked!!!!! Contact the Bank");
                }
            }
        }
    }

}
