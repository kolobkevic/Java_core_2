package com.kolobkevic.java_core_2.lessons.lesson_2;

public class Main {
    public static void main(String[] args) {
        SumArrayElements sum = new SumArrayElements();

        String[][] array_1 = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"},   {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};
        String[][] array_2 = {{"2", "2", "2", "2"}, {"2", "2", "2", "2"},   {"2", "2", "2", "2"}, {"2", "2", "2", "2"}};
        String[][] array_3 = {{"3", "3", "3"},      {"3", "3", "3", "3"},   {"3", "3", "3", "3"}, {"3", "3", "3", "3"}}; //неверный размер массива
        String[][] array_4 = {{"4", "4", "4", "4"}, {"4", "4", "4", "4"},   {"4", "4", "4", "4"}};                       //неверный размер массива
        String[][] array_5 = {{"5", "5", "5", "5"}, {"5", "5", "3V5", "5"}, {"5", "5", "5", "5"}, {"5", "5", "5", "5"}}; //нецифровой элемент в массиве
        String[][] array_6 = {{"6", "6", "6", "6"}, {"6", "6", "6", "6"},   {"6", "6", "6", "6"}, {"6", "6", "6", "6"}};

        sum.checkSum(array_1);
        sum.checkSum(array_2);
        sum.checkSum(array_3);
        sum.checkSum(array_4);
        sum.checkSum(array_5);
        sum.checkSum(array_6);

    }
}
