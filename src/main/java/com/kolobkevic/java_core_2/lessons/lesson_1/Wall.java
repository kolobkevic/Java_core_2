package com.kolobkevic.java_core_2.lessons.lesson_1;

public class Wall implements Barrier {
    double height;

    Wall(double h) {
        height = h;
    }

    @Override
    public boolean passingBarrier(double a) {
        if (height > a) {
            System.out.println("Barrier is not passed");
            return false;
        } else {
            System.out.println("Barrier is passed");
            return true;
        }
    }
}
