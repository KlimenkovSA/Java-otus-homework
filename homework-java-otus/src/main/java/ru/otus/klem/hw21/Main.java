package ru.otus.klem.hw21;
//Реализация №1
//Реализуйте метод, который создает double массив длиной 100_000_000 элементов
//Метод должен должен циклом for пройти по каждому элементу и посчитать его значение по формуле: array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
//Засеките время выполнения цикла и выведите его в консоль.
//
//Реализация №2:
//Сделайте то же самое что и в реализации один, только чтобы массив заполняли 4 потока одновременно.
//То есть первый поток заполняет первую четверть массива, второй - вторую и т.д. И посмотрите насколько быстрее выполнится работа по сравнению с одним потоком.

public class Main {
    static double[] array = new double[10_000_000];
    public static void main(String[] args) throws InterruptedException {
        long t = System.currentTimeMillis();
        fillArray(array);
        System.out.println("Реализация №1: " + (System.currentTimeMillis() - t));
        t = System.currentTimeMillis();
        fourStreamsFill(array);
        System.out.println("Реализация №2: " + (System.currentTimeMillis() - t));
    }
    public static void fillArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }
    public static void fourStreamsFill(double[] array) throws InterruptedException {
        Thread[] threadArray = new Thread[4];
        for (int j = 0; j < threadArray.length; j++) {
            int counter = j;
            threadArray[j] = new Thread(
                    () -> {
                        int i;
                        for (int k = 0; k < array.length; k = k + 4) {
                            i = k + counter;
                            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                        }
                    }
            );
            threadArray[j].start();
        }
        for (Thread thread : threadArray) {
            thread.join();
        }
    }
}
