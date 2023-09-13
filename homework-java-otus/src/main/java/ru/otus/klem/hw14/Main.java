package ru.otus.klem.hw14;

//Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4. Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
//Метод должен обойти все элементы массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит текст вместо числа),
//должно быть брошено исключение AppArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//В методе main() необходимо вызвать полученный метод, обработать возможные исключения AppArraySizeException и AppArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
public class Main {
    public static void main(String[] args) {
        try {
            String[][] arr = new String[][]{{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};
            System.out.println(sumOfElements(arr));
        } catch (AppArraySizeException ex) {
            System.out.println("Не корректный массив");
        } catch (
                AppArrayDataException ex) {
            System.out.println("Не корректный тип в ячейке: " + ex.i + "x" + ex.j);
        }
    }


    public static int sumOfElements(String[][] arr) throws RuntimeException {
        int summ = 0;
        if (arr.length != 4) {
            throw new AppArraySizeException();
        }
        for (String[] strings : arr) {
            if (strings.length != 4) {
                throw new AppArraySizeException();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    summ += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(i, j);
                }
            }
        }
        return summ;
    }


}
