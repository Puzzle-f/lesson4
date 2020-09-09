package lesson5;

public class Main {

    public static int size = 1000000;
    static final int h = size / 2;

    static void arrOneThread(int size){
           float[] arr = new float[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("Один поток: "+(System.currentTimeMillis() - a) + " мс");
    }

    public static void threads(){
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        long a = System.currentTimeMillis();
            t1.start();
            t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.currentTimeMillis();
        System.out.println("2 потока: " + (System.currentTimeMillis()-a) + " мс");
    }

    public static void main(String[] args)  {

        threads();
        arrOneThread(size);
    }
}
