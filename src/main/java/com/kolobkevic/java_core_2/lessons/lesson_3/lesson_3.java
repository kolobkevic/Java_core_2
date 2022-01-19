package com.kolobkevic.java_core_2.lessons.lesson_3;

import java.util.*;

public class lesson_3 {
    public static void main(String[] args) {
        wordsListHandling();

        Phonebook phonebook=new Phonebook();
        phonebook.add("+79019010101", "Ivanov");
        phonebook.add("+79019010102", "Petrov");
        phonebook.add("+79019010103", "Malkovich");
        phonebook.add("+79019010104", "DiCaprio");
        phonebook.add("+79019010144", "DiCaprio");
        phonebook.add("+79019010105", "Gates");
        phonebook.add("+79019010155", "Gates");
        phonebook.add("+79019010106", "Sidorov");
        phonebook.add("+79019010107", "Gates");

        System.out.println(phonebook.get("DiCaprio"));
        System.out.println(phonebook.get("Gates"));
    }

    private static void wordsListHandling() {
        List<String> wordsList = new ArrayList<>(Arrays.asList("Human", "Cat", "Dog", "Shark", "Lion",
                "Tiger", "Cow", "Pig", "Dog", "Lion",
                "Duck", "Goat", "Donkey", "Chicken", "Horse",
                "Cow", "Rabbit", "Ship", "Fox", "Monkey"));
        System.out.println(wordsList);
        Map<String, Integer> wordsMap = new LinkedHashMap<>();
        for (String s : wordsList) {
            wordsMap.put(s, Collections.frequency(wordsList, s));
        }

        for (Map.Entry entry : wordsMap.entrySet()) {
            if (entry.getValue().equals(1)) {
                System.out.printf("%d %s. ", entry.getValue(), entry.getKey());
            } else {
                System.out.printf("%d %ss. ", entry.getValue(), entry.getKey());
            }
        }
        System.out.println();
    }
}
