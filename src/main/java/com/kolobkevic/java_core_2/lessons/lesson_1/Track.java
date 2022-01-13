package com.kolobkevic.java_core_2.lessons.lesson_1;

public class Track implements Barrier {
    double length;

    Track(double l) {
        length = l;
    }

    @Override
    public boolean passingBarrier(double a) {
        if (length > a) {
            System.out.println("Barrier is not passed");
            return false;
        } else {
            System.out.println("Barrier is passed");
            return true;
        }
    }
}
