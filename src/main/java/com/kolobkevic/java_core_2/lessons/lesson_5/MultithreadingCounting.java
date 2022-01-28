package com.kolobkevic.java_core_2.lessons.lesson_5;

public class MultithreadingCounting {

    protected void secondMethod(int threadsCount, float[] arr1) {
        int k = arr1.length / threadsCount;
        float[][] list = new float[threadsCount][k];
        Thread[] thr = new Thread[threadsCount];

        long b = System.currentTimeMillis();

        for (int j = 0; j < threadsCount; j++) {
            System.arraycopy(arr1, j * k, list[j], 0, k);
        }

        for (int i = 0; i < threadsCount; i++) {
            int finalI = i;
            thr[i] = new Thread(() -> {
                for (int j = 0; j < k; j++) {
                    list[finalI][j] = (float) (list[finalI][j] * Math.sin(0.2f + (j + k * finalI) / 5) * Math.cos(0.2f + (j + k * finalI) / 5) * Math.cos(0.4f + (j + k * finalI) / 2));
                }
            });
            thr[i].start();
        }

        for (Thread thread : thr) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j < threadsCount; j++) {
            System.arraycopy(list[j], 0, arr1, j * k, k);
        }
        System.out.printf("Elapsed time of second method: %d ms %n", (System.currentTimeMillis() - b));
    }
}