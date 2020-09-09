package lesson5;

public class Thread1 implements Runnable {

   static int size = 1000000;

    static final int h = size / 2;
    float[] arr = new float[size];

    @Override
    public void run() {
//        float[] a1 = new float[h];
        for (int i = 0; i < h; i++) {
            arr[i] = 1;
        };
        long a = System.currentTimeMillis();
        for (int i = 0; i < h; i++) {
//                                      С ПЕРЕЗАПИСЫВАНИЕМ ПОЛУЧАЕТСЯ ДОЛЬШЕ
//            System.arraycopy(arr, 0, a1, 0, h);
//            a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//            System.arraycopy(a1, 0, arr, 0, h);
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("Первый поток: "+(System.currentTimeMillis() - a) + " мс");
        }


    }
