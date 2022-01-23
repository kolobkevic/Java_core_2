package com.kolobkevic.java_core_2.lessons.lesson_3;

import java.util.*;

public class Phonebook {
    private Map<String, String> phonebook = new HashMap<>();

    // Номер тоже сделал строковым специально
    public void add(String number, String surname) {
        phonebook.put(number, surname);
    }

    public List<String> get(String surname) {
        List<String> numbersList = new ArrayList<>(); // Я правильно понимаю, что если переменная не нужна вне метода, ее лучше объявлять в нем?
        for (String key : phonebook.keySet()) {
            if (surname.equalsIgnoreCase(phonebook.get(key))) {
                numbersList.add(key);
            }
        }
        return numbersList;
    }
}
