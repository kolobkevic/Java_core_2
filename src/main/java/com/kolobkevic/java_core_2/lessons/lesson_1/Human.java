package com.kolobkevic.java_core_2.lessons.lesson_1;

public class Human implements Creature {
    @Override
    public void jump() {
        System.out.println("Human jumps");
    }

    @Override
    public void run() {
        System.out.println("Human runs");
    }

    double maxJumpHeight, maxDistance;

    public Human(double maxDistance, double maxJumpHeight) {
        this.maxDistance = maxDistance;
        this.maxJumpHeight = maxJumpHeight;
    }
}
