package ru.otus.klem.hw12;


public class MainApp {
    public static void main(String[] args) {

        Plate plate = new Plate(50, 10);
        System.out.println(plate);
        Cat[] cats = {
                new Cat("Tom", 10, false),
                new Cat("Barsik", 20, false),
                new Cat("Murzik", 30, false),
        };

        plate.fill(20);
        System.out.println(plate);
        plate.fill(30);
        System.out.println(plate);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
            System.out.println(plate);
        }
    }
}
