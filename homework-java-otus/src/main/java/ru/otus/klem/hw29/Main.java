package ru.otus.klem.hw29;

//Создайте пул потоков
//Задайте пулу три задачи: первая должна 5 раз напечатать букву A, вторая - B, третья - C
//Синхронизируйте потоки в пуле таким образом, чтобы в любой ситуации в консоль печаталась последовательность ABCABCABCABCABC
//После печати всех символов программа должна завершиться

import java.awt.image.ImagingOpException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;

public class Main  {
    private static final Counter counter = new Counter();
    private static final Object mon = new Object();

    public static void main(String[] args) throws ExecutionException, ImagingOpException {
        ExecutorService service = newFixedThreadPool(3);
        counter.setValue(1);
        service.execute(Main::printA);
        service.execute(Main::printB);
        service.execute(Main::printC);
        service.shutdown();
    }

    public static void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (counter.getValue() != 1) {
                        mon.wait();
                    }
                    counter.setValue(2);
                    System.out.print("A");
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (counter.getValue() != 2) {
                        mon.wait();
                    }
                    counter.setValue(3);
                    System.out.print("B");
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (counter.getValue() != 3) {
                        mon.wait();
                    }
                    counter.setValue(1);
                    System.out.print("C");
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


