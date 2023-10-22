package ru.otus.klem.hw30;
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
//Реализовать набор тестов для методов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        System.out.println(transformArray(List.of(1, 2, 1, 2, 2)));
        System.out.println(checkArray(List.of(1, 2)));
        System.out.println(checkArray(List.of(1, 1)));
        System.out.println(checkArray(List.of(1, 3)));
        System.out.println(checkArray(List.of(1, 2, 3)));
        System.out.println(checkArray(List.of(1, 2, 2, 1)));
        System.out.println(transformArray(List.of(2, 2, 2, 2)));
    }


    public static List<Integer> transformArray(List<Integer> array) {
        List<Integer> newArray = new ArrayList<>();

        int indexLast1 = -1;
        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i) == 1) {
                indexLast1 = i;
                break;
            }
        }

        if (indexLast1 == -1) {
            throw new RuntimeException();
        }

        for (int i = indexLast1 + 1; i < array.size(); i++) {
            newArray.add(array.get(i));
        }

        return newArray;
    }

    public static boolean checkArray(List<Integer> array) {
        Map<Integer, Boolean> check = new HashMap<>();
        check.put(1, false);
        check.put(2, false);
        check.put(null, true);
        boolean result = false;

        for (Integer integer : array) {
            if (check.containsKey(integer) && !check.get(integer)) {
                check.put(integer, true);
            } else if (!check.containsKey(integer)) {
                check.put(null, false);
            }
        }
        System.out.println(check);

        if (check.containsValue(false)) {
            return false;
        }
        return true;
    }
}
