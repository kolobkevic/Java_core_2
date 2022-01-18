package com.kolobkevic.java_core_2.lessons.lesson_2;

public class SumArrayElements {

    protected void checkArray(String[][] arr) {
        for (String[] strings : arr) {
            if (arr.length != 4 | strings.length != 4) {
                throw new MyArraySizeException("Wrong size of an array");
            }
        }
    }

    protected int sumArrayElements(String[][] arr) {
        int summa = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (char c : arr[i][j].toCharArray()) {
                    if (!Character.isDigit(c)) {
                        throw new MyArrayDataException("Non-digit symbol at [" + i + "][" + j + "]");
                    }
                }
                summa += Integer.parseInt(arr[i][j]);
            }
        }
        return summa;
    }

    protected void checkSum(String[][] arr) {
        try {
            checkArray(arr);
            System.out.printf("Sum of the array = %d\n", sumArrayElements(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
