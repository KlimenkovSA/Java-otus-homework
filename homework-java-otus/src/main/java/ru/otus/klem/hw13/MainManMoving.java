package ru.otus.klem.hw13;

import ru.otus.klem.hw13.transport.Bicycle;
import ru.otus.klem.hw13.transport.Car;
import ru.otus.klem.hw13.transport.Horse;
import ru.otus.klem.hw13.transport.Rover;

public class MainManMoving {
    public static void main(String[] args) {
        Man man = new Man("Sergey", "foot");
        Bicycle bicycle = new Bicycle(false,200);
        Car car = new Car(false,100,500);
        Horse horse = new Horse(false,300,100);
        Rover rover = new Rover(false,50,100);
        TypeTerrain typeTerrain = TypeTerrain.FOREST;

        man.getTransport(car);
        System.out.println(man);


        man.getTransport(car);
    }
}
