package com.kolobkevic.java_core_2.lessons.lesson_5;

import java.util.Arrays;

public class Main {
    static final int size = 100000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] arr1 = new float[size];
    static float[] arr2 = new float[size];

    public static void main(String[] args) {

        Arrays.fill(arr, 1);
        Arrays.fill(arr1, 1);
        Arrays.fill(arr2, 1);

        firstMethod();
        secondMethod();
        new MultithreadingCounting().secondMethod(2,arr2);


        System.out.println(Arrays.equals(arr, arr1));
        System.out.println(Arrays.equals(arr1, arr2));
    }

    static void firstMethod() {

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.printf("Elapsed time of first method: %d ms %n", (System.currentTimeMillis() - a));
    }

    static void secondMethod() {

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long b = System.currentTimeMillis();

        System.arraycopy(arr1, 0, a1, 0, h);
        System.arraycopy(arr1, h, a2, 0, h);

        Thread k = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        k.start();

        Thread k1 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        });
        k1.start();

        try {
            k.join();
            k1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr1, 0, h);
        System.arraycopy(a2, 0, arr1, h, h);

        System.out.printf("Elapsed time of second method: %d ms %n", (System.currentTimeMillis() - b));
    }
}
