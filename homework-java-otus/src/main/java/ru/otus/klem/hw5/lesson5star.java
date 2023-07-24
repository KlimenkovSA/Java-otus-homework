package ru.otus.klem.hw5;

import java.util.Arrays;
import java.util.Scanner;

//Реализуйте метод, принимающий на вход набор целочисленных массивов, и получающий новый
//массив равный сумме входящих;
//        Пример: { 1, 2, 3 } + { 2, 2 } + { 1, 1, 1, 1, 1} = { 4, 5, 4, 1, 1 }
//● Реализуйте метод, проверяющий что есть “точка” в массиве, в которой сумма левой и правой части
//        равны. “Точка находится между элементами”;
//        Пример: { 1, 1, 1, 1, 1, | 5 }, { 5, | 3, 4, -2 }, { 7, 2, 2, 2 }, { 9, 4 }
//● Реализуйте метод, проверяющий что все элементы массива идут в порядке убывания или  возрастания (по выбору пользователя)
//● Реализуйте метод, “переворачивающий” входящий массив Пример: { 1 2 3 4 } => { 4 3 2 1 }
public class lesson5star {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {2, 2};
        int[] arr3 = {1, 1, 1, 1, 1};

        int[] array1 = {2, 3, 0, 1, 4, 10};
        int[] array2 = {5, 3, 4, -2};
        int[] array3 = {7, 2, 2, 2};
        int[] array4 = {9, 4};

        int[] checkArray = {7, 6, 5, 4, 3};

        int[] reverse = {9, 8, 7, 6, 5};
        System.out.println("Результат сложения массивов: " + Arrays.toString(sumСomparison(arr1, arr2, arr3)));
        border(array1);
        border(array2);
        border(array3);
        border(array4);
        checkIncrease(checkArray);

        String resultReverse = reverseArray(Arrays.toString(reverse));
        System.out.println(resultReverse);
    }

    public static int[] sumСomparison(int[] arr1, int[] arr2, int[] arr3) {
        int length = arr1.length;
        if (length < arr2.length) {
            length = arr2.length;
        }
        if (length < arr3.length) {
            length = arr3.length;
        }

        int[] resArr = new int[length];

        for (int i = 0; i < arr1.length; i++) {
            resArr[i] += arr1[i];
            //System.out.print(resArr[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            resArr[i] += arr2[i];
            //System.out.print(resArr[i]);
        }

        for (int i = 0; i < arr3.length; i++) {
            resArr[i] += arr3[i];
            //System.out.print(resArr[i]);
        }
        return resArr;
    }

    public static void border(int... array) {
        System.out.println(Arrays.toString(array));
        int left = 0;
        int right = Arrays.stream(array).sum();
        for (int a : array) {
            if (left == right) {
                System.out.println("найдена точка для массива:" + Arrays.toString(array));
                break;
            }
            left += a;
            right -= a;
        }
    }

    public static void checkIncrease(int... array) {
        //System.out.println(Arrays.toString(array));   //{1, 3, 2, 5, 4};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какой медот проверки применить к массиву "+ Arrays.toString(array) + " up - Возрастание, down - убывание ");
        String func = scanner.next();
        if (func.equals("up")){
            int a = array[0];
            for (int i = 0; i < array.length; i++) {
                if (a == array[i]){
                    System.out.println(a);
                    a += 1;

                }
                else {
                    System.out.println("порядок нарушен на " + (i+1) + " элементе");
                    break;
                }
            }
        } else if (func.equals("down")) {
            int a = array[0];
            for (int i = 0; i < array.length; i++) {
                if (a == array[i]){
                    System.out.println(a);
                    a -= 1;
                }
                else {
                    System.out.println("порядок нарушен на " + (i+1)  + " элементе");
                    break;
                }
            }
        } else {
            System.out.println("оператор не найден введите up или down");
        }
    }
    public static String reverseArray(String reverse) {
        return new StringBuilder(reverse).reverse().toString();
    }
}
