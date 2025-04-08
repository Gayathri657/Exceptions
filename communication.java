public class communication {
    int i;
    boolean flag = true;

    public synchronized void put(int x) {
        if (!flag) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Unexpected error");
            }
        } else {
            i = x;
            System.out.println("channel1 produce the data " + x);
            flag = false;
            notify();
        }

    }

    public synchronized void get() {
        if (flag) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println("Unexpected error");
            }
        } else {
            System.out.println("channel2 consumed the data  " + i);
            flag = true;
            notify();
        }

    }
}

class channel1 extends Thread {
    communication c;
    boolean flag = true;

    channel1(communication c) {
        this.c = c;
    }

    public void run() {

        int i = 0;
        while (true) {
            c.put(i++);
        }

    }

}

class channel2 extends Thread {
    communication c;

    channel2(communication c) {
        this.c = c;
    }

    public void run() {

        while (true) {
            c.get();
        }
    }

}

class Main2 {
    public static void main(String[] args) {
        communication c = new communication();
        channel1 a = new channel1(c);
        channel2 b = new channel2(c);
        a.start();
        b.start();
    }
}