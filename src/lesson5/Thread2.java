package lesson5;

public class Thread2 implements Runnable{

    static int size = 1000000;
    static final int h = size / 2;
    float[] arr = new float[size];


    @Override
    public void run() {
//        float[] a2 = new float[h];
        for (int i = 0; i < h; i++) {
            arr[i] = 1;
        };
        long a = System.currentTimeMillis();
        for (int i = h; i < arr.length; i++) {
//                                      С ПЕРЕЗАПИСЫВАНИЕМ ПОЛУЧАЕТСЯ ДОЛЬШЕ
//            System.arraycopy(arr, 0, a2, 0, h);
//            a2[i-h] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//            System.arraycopy(a2, 0, arr, h, h);
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("Второй поток: "+(System.currentTimeMillis() - a) + " мс");
    }
    }

