import java.util.Scanner;

class threading implements Runnable {
    public void run() {

        message();
        addition();

    }

    public void addition() {
        for (int i = 0; i < 10; i++) {
            System.out.println("How you doing?");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Unexpected error");
            }
        }
    }

    public void message() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hellooooooo, This is Gayathri");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("Unexpected error");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        threading th = new threading();
        Thread a = new Thread(th);
        Thread b = new Thread(th);
        a.setName("ABC");
        b.setName("XYZ");
        a.start();
        b.start();

    }
}
