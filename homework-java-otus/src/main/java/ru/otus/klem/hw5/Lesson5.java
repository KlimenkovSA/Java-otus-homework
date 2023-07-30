package ru.otus.klem.hw5;

public class Lesson5 {
    public static void main(String[] args) {
        int number = 8;
        String str = "hell";
        int[] arr = {2, 5, 9, 3, 11};
        int[] emptyArray = new int[10];

        printStrings(number, str);
        printSumArr(arr);
        fillArr(number, emptyArray);
        System.out.println();
        upArray(number, arr);
        System.out.println();
        sumСomparison(arr);
    }
    public static void printStrings(int numb, String word) {
        for (int i = 0; i < numb; i++) {
            System.out.println(word);
        }
        System.out.println();
    }
    public static void printSumArr(int[] arr) {
        int sumRez = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sumRez += arr[i];
            }
        }
        System.out.println(sumRez);
    }
    public static void fillArr(int numb, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numb;
            System.out.print(arr[i] + " ");
        }
    }

    public static void upArray(int numb, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += numb;
            System.out.print(arr[i] + " ");
        }
    }
    public static void sumСomparison(int[] arr) {
        int parity = 1;
        if (arr.length % 2 == 0) {
            parity = 0;
        }
        int sumLeft = 0;
        for (int i = 0; i < arr.length / 2 + parity; i++) {
            sumLeft += arr[i];

        }
        //System.out.println(sumLeft);
        int sumRight = 0;
        for (int i = arr.length / 2; i < arr.length; i++) {
            sumRight += arr[i];
        }
        //System.out.println(sumRight);
        if (sumLeft > sumRight) {
            System.out.println("Сумма элементов левой половины массива: " + sumLeft + " больше " + sumRight);
        } else {
            System.out.println("Сумма элементов правой половины массива: "+ sumRight + " больше " + sumLeft);
        }
    }
}
