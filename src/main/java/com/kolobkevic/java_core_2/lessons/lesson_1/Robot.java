package com.kolobkevic.java_core_2.lessons.lesson_1;

public class Robot implements Creature {
    @Override
    public void jump() {
        System.out.println("Robot jumps");
    }

    @Override
    public void run() {
        System.out.println("Robot runs");
    }
}
