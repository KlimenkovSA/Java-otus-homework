package ru.otus.klem.hw30logtest;
//Реализовать метод, принимающий в качестве аргумента одномерный целочисленный массив, и возвращающий новый массив, который содержит элементы исходного массива, идущие после последней единицы. Если входной массив не содержит единиц, то должно быть брошено RuntimeException.
//Примеры:
//Входной массив: [ 1 2 1 2 2 ] => Результат: [ 2 2 ]
//Входной массив: [ 2 2 2 2 ] => RuntimeException
//Реализовать метод, проверяющий входной массив, что он состоит только из чисел 1 и 2. Если в массиве присутствуют числа кроме 1 и 2, или нет хотя бы одной единицы или двойки, то результат должен быть равен false
//Примеры:
//[ 1 2 ] => true
//[ 1 1 ] => false
//[ 1 3 ] => false
//[ 1 2 2 1 ] => true
//[ 1 2 3] => false
//Реализовать набор тестов для методов.

import java.util.Arrays;

import static ru.otus.klem.hw30logtest.CheckArrarys.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(newArray(new int[]{1, 2, 1, 2, 2})));
        //System.out.println(Arrays.toString(newArray(new int[]{2, 2, 2, 2, 2}))); //RuntimeException

        System.out.println("rezult 1 = " + checkVal(new int[]{1, 2}));
        System.out.println("rezult 2 = " + checkVal(new int[]{1, 1}));
        System.out.println("rezult 3 = " + checkVal(new int[]{1, 3}));
        System.out.println("rezult 4 = " + checkVal(new int[]{1, 2, 2, 1}));
        System.out.println("rezult 5 = " + checkVal(new int[]{1, 2, 3}));

    }
}
