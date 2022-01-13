package com.kolobkevic.java_core_2.lessons.lesson_1;

public class Cat implements Creature {
    @Override
    public void jump() {
        System.out.println("Cat jumps");
    }

    @Override
    public void run() {
        System.out.println("Cat runs");
    }
}
