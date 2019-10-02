public class Main {

    public static void firstMethod() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];


        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        // 3) Засекают время выполнения: long a = System.currentTimeMillis();
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        // 6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
        System.out.println("Время работы первого метода: " + (System.currentTimeMillis() - a));

    }

    public static void secondMethod() throws InterruptedException {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        // Замеряем время разбивки массива на 2 массива
        long a = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        t1.start();
        t1.join();

        //Время расчета первого массива
        long b = System.currentTimeMillis();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
               }
            }
        });
        t2.start();
        t2.join();

        //Время расчета второго массива
        long c = System.currentTimeMillis();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        // Время склейки второго массива
        long arrTime = System.currentTimeMillis();

        System.out.println("Время разбивки на 2 массива: " + (System.currentTimeMillis() - a));
        System.out.println("Время расчета первого массива: " + (b - a));
        System.out.println("Время расчета второго массива: " + (c - b));
        System.out.println("Время склейки: " + (arrTime - c));
    }
        public static void main (String[]args) /*либо можно тут прописать trows InterruptedException */ {
            firstMethod();
            try {
                secondMethod();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


