package cache_problem;

import java.util.Arrays;
import java.util.Random;

public class FalseSharing {

    static PaddedInt[] padded;
    static UnPaddedInt[] unPadded;

    static final int MAX_ITERATIONS = 100;
    static class PaddedInt{
        int a1, a2, a3, a4, a5;
        volatile int n = 0;
        int b1, b2, b3, b4, b5;
    }
    static class UnPaddedInt{
        volatile int n = 0;
    }

    static{
        padded = new PaddedInt[4];
        for(int i = 0; i < padded.length; i++){
            padded[i] = new PaddedInt();
        }

        unPadded = new UnPaddedInt[4];
        for(int i = 0; i < unPadded.length; i++){
            unPadded[i] = new UnPaddedInt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long start, end;
        Random r = new Random();
        Runnable paddedRunnable = () ->{

                for (int j = 0; j < 4; j++) {
                    padded[j].n = r.nextInt();
                }
        };


        Runnable unPaddedRunnable = () ->{
            for (int j = 0; j < 4; j++) {
                    unPadded[j].n = r.nextInt();
            }
        };

        Thread[] threads = new Thread[MAX_ITERATIONS];
        for(int i = 0; i < MAX_ITERATIONS; i++){
            threads[i] = new Thread(paddedRunnable);
        }
        start = System.currentTimeMillis();
        for(Thread t : threads){
            t.start();
        }
        for(Thread t : threads){
            t.join();
        }
        end = System.currentTimeMillis();
        System.out.printf("Padded - Time: %dms%n", end - start);

//        System.gc(); // invoke Garbage Collector


        threads = new Thread[MAX_ITERATIONS];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(unPaddedRunnable);
        }
        start = System.currentTimeMillis();
        for(Thread t : threads) {
            t.start();
        }
        for(Thread t : threads) {
            t.join();
        }
        end = System.currentTimeMillis();
        System.out.printf("Unpadded - Time: %dms%n", end - start);
    }



}
