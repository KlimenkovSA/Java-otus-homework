package ru.otus.klem.hw13.transport;

public class Rover {
    private boolean used;
    private int distance;
    private int fuel;

    public Rover(boolean used, int distance, int fuel) {
        this.used = used;
        this.distance = distance;
        this.fuel = fuel;
    }
}
