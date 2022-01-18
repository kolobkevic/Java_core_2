package com.kolobkevic.java_core_2.lessons.lesson_1;

public class Main {
    public static void main(String[] args) {
        Creature [] creatures = {new Cat(), new Human(1, 1), new Robot()};
        for (Creature creature : creatures) {
            creature.jump();
            creature.run();
        }

        Human [] humans = {new Human(1.5, 2.0), new Human(2.4, 3.2),
                new Human(6.4, 7.2), new Human(1.3, 0.2)};
        Barrier [] barriers = {new Wall(1.6), new Track(1.4), new Wall(2.5), new Track(2.8)};

        for (int i = 0; i < humans.length; i++) {
            System.out.println();
            System.out.println("Human №" + (i + 1) + " starts running");
            for (Barrier barrier : barriers) {
                if (barrier instanceof Track) {
                    if (!barrier.passingBarrier(humans[i].maxDistance))
                        break;
                } else if (!barrier.passingBarrier(humans[i].maxJumpHeight))
                    break;
            }
        }
    }
}