package ru.otus.klem.hw15;

import java.util.*;

//Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
//Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
//Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен переписать каждую заполненную ячейку списка указанным числом;
//Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент списка на указанное число;
//Создайте класс Сотрудник с полями: имя, возраст;
//Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
//Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
//Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий что средний возраст сотрудников превышает указанный аргумент;
//Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
public class MainApp {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList(Arrays.asList(1, 6, 3, 4, 5, 6, 6));
        System.out.println(rangeFilling(1, 10));
        System.out.println(summOfElem(myList));
        System.out.println(rewrite(7, myList));
        System.out.println(increase(1, myList));
    }

    public static List<Integer> rangeFilling(int min, int max) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = min; i <= max; i += 1) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public static int summOfElem(ArrayList<Integer> myList) {
        int sum = 0;
        for (Integer integer : myList) {
            if (integer > 5) {
                sum += integer;
            }
        }
        return sum;
    }

    public static ArrayList<Integer> rewrite(int val, ArrayList<Integer> newList) {
        for (int i = 0; i < newList.size(); i++) {
            newList.set(i, val);
        }
        return newList;
    }

    public static ArrayList<Integer> increase(int val, ArrayList<Integer> newList) {
        for (int i = 0; i < newList.size(); i++) {
            newList.set(i, newList.get(i) + val);
        }
        return newList;
    }


}
