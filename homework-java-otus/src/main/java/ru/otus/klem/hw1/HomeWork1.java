package ru.otus.klem.hw1;

import java.util.Scanner;

public class HomeWork1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 5");
        while (true) {
            int enterNumb = scanner.nextInt();
            if (enterNumb == 1) {
                System.out.println("Запуск метода № " + enterNumb);
                greetings();
                break;
            } else if (enterNumb == 2) {
                System.out.println("Запуск метода № " + enterNumb);
                checkSign((int) (Math.random() * 10), (int) (Math.random() * 10), (int) (Math.random() * 10));
                break;
            } else if (enterNumb == 3) {
                System.out.println("Запуск метода № " + enterNumb);
                selectColor();
                break;
            } else if (enterNumb == 4) {
                System.out.println("Запуск метода № " + enterNumb);
                compareNumbers();
                break;
            } else if (enterNumb == 5) {
                System.out.println("Запуск метода № " + enterNumb);
                addOrSubtractAndPrint((int) (Math.random() * 10), (int) (Math.random() * 10), (Math.random() < 0.5));
                break;
            } else {
                System.out.println("такого метода не существует, введите другое число !");
            }
        }
    }

    public static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }п

    public static void selectColor() {
        int data = 25;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data > 10 && data <= 20) {
            System.out.println("Желтый");
        } else if (data > 20) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 3;
        int b = 2;
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");

    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int res;
        if (increment) {
            res = initValue + delta;
            System.out.println("Результат сложения: " + res);
        } else {
            res = initValue - delta;
            System.out.println("Результат вычитания: " + res);
        }
    }


}
