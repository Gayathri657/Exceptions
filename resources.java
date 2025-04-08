public class resources implements Runnable {
    String book1 = "java";
    String book2 = "spring";
    String book3 = "maven";

    public void run() {
        String tName = Thread.currentThread().getName();
        if ("Student1".equals(tName)) {
            synchronized (book1) {
                System.out.println(tName + " took book1");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Unexpected error");
                }

                synchronized (book2) {
                    System.out.println(tName + " took book2");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Unexpected error");
                    }

                    synchronized (book3) {
                        System.out.println(tName + " took book3");
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.out.println("Unexpected error");
                        }
                    }
                }
            }

        } else {
            synchronized (book1) {
                System.out.println(tName + " took book1");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Unexpected error");
                }

                synchronized (book2) {
                    System.out.println(tName + " took book2");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        System.out.println("Unexpected error");
                    }

                    synchronized (book3) {
                        System.out.println(tName + " took book3");
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.out.println("Unexpected error");
                        }
                    }
                }
            }

        }

    }

}

class students {
    public static void main(String[] args) {
        resources r = new resources();
        Thread th = new Thread(r);
        Thread th1 = new Thread(r);
        th.setName("Student1");
        th1.setName("Student2");
        th.start();
        th1.start();
    }
}
