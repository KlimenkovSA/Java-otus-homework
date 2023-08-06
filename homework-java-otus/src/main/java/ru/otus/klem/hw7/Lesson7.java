package ru.otus.klem.hw7;

//Реализовать метод  sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив, метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
//Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль квадрат из символов * со сторонами соответствующей длины;
//Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив, и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
//Реализовать метод  findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
//Реализуйте  метод, который считает сумму элементов второй строки двумерного массива, если второй строки не существует, то в качестве результата необходимо вернуть -1
public class Lesson7 {
    public static void main(String[] args) {

        int[][] arr2D = {{3, 2, 1}, {6, 1, -3}};
        int rezult = sumOfPositiveElements(arr2D);
        int SIZE = 10;
        int[][] diagonal = new int[SIZE][SIZE];
        int maxVal = findMax(arr2D);
        int str = 2;
        int sumChosenStr = sumChoseRow(arr2D, str);

        System.out.println("Сумма всех элеметов массива: " + rezult);
        drawSquare(SIZE);
        drawSqDiagonal(diagonal);
        System.out.println("Максимальное значение массива: " + maxVal);
        System.out.println("Сумма строки(" + str + ") равна " + sumChosenStr);
    }

    public static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    public static void drawSquare(int size) {
        char[][] arrSq = new char[size][size];
        for (int i = 0; i < arrSq.length; i++) {
            for (int j = 0; j < arrSq[i].length; j++) {
                arrSq[i][j] = '*';
            }
        }

        for (int i = 0; i < arrSq.length; i++) {
            for (int j = 0; j < arrSq[i].length; j++) {
                System.out.print(arrSq[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void drawSqDiagonal(int[][] diagonal) {
        for (int i = 0; i < diagonal.length; i++) {
            for (int j = 0; j < diagonal[i].length; j++) {
                if (i == j || diagonal[i].length - i - 1 == j) {
                    diagonal[i][j] = 0;
                } else {
                    diagonal[i][j] = 11;
                }
                System.out.print(diagonal[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int findMax(int[][] array) {
        int first = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (first < array[i][j]) {
                    first = array[i][j];
                }
            }
        }
        return first;
    }

    public static int sumChoseRow(int[][] array, int str) {
        int sumStr2 = 0;
        if (array.length >= str) {
            for (int i = str - 1; i < str; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    sumStr2 += array[i][j];
                }
            }
        } else {
            return -1;
        }
        return sumStr2;
    }
}
