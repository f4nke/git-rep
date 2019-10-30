public class Task1 {
    static Object mon = new Object();
        static volatile char symb = 'A';
       


    public static void main(String[] args) {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int local_score = 1;
                try {
                    while (local_score <= 5) {
                        synchronized (mon) {
                            while (symb != 'A') {
                                mon.wait();
                            }
                            System.out.print("A");
                            local_score++;
                            symb = 'B';
                            mon.notifyAll();

                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int local_score = 1;
                try {
                    while (local_score <= 5) {


                        synchronized (mon) {
                            while (symb != 'B') {
                                mon.wait();
                            }
                            System.out.print("B");
                            local_score++;
                            symb = 'C';
                            mon.notifyAll();

                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });t2.start();



        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                int local_score = 1;
                try {
                    while (local_score <= 5) {
                        synchronized (mon) {
                            while (symb != 'C') {
                                mon.wait();
                            }
                            System.out.print("C");
                            local_score++;
                            symb = 'A';
                            mon.notifyAll();


                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });t3.start();
    }
}



