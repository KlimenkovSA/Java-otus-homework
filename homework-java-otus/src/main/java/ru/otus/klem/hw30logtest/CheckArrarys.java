package ru.otus.klem.hw30logtest;

import java.util.Arrays;

public class CheckArrarys {
    public static int[] newArray(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 1) {
                return Arrays.copyOfRange(a, i + 1, a.length);
            }
        }
        throw new RuntimeException();

    }

    public static boolean checkVal(int[] array) {
        boolean val1 = false;
        boolean val2 = false;

        for (int j : array) {
            if (j < 1 || j > 2) {
                return false;
            } else if (j == 1) {
                val1 = true;
            } else val2 = true;
        }
        return val1 && val2;
    }
}