public class synrchonise implements Runnable {
    int tickets = 10;

    public synchronized void run() {
        String Name = Thread.currentThread().getName();
        tickets--;
        System.out.println("User " + Name + " brought the ticket: Remaining tickets are " + tickets);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Unexpected error");
        }
        if (tickets == 0) {
            System.out.println("Tickets are sold out");
        }

    }
}

class Main1 {
    public static void main(String[] args) {
        synrchonise s = new synrchonise();
        Thread[] th = new Thread[10];
        for (int i = 0; i < 10; i++) {
            th[i] = new Thread(s);
            th[i].setName(String.valueOf(i));
            th[i].start();
        }

    }
}
