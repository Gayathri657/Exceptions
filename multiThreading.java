import java.util.Scanner;

class Addition extends Thread {
    public void run() {
        Scanner a = new Scanner(System.in);
        int ab = a.nextInt();
        int bc = a.nextInt();
        int add = ab + bc;
        System.out.println(add);
    }
}

class Message extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hi everyone, Is everything fine????");
            try {
                Thread.sleep(1000); // Pauses for 1 second
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
                return; // Exit the loop if the thread is interrupted
            }
        }
    }
}

public class multiThreading {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting on the main thread");
        Addition ax = new Addition();
        Message mx = new Message();
        ax.start();
        mx.start();
        System.out.println("Ending of the main thread");
    }
}
