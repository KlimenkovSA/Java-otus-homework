package ru.otus.klem.hw13.transport;

public class Bicycle {
    private boolean used;
    private int distance;

    public Bicycle(boolean used, int distance) {
        this.used = used;
        this.distance = distance;
    }

    public void move (){
        System.out.println("проехал");

    }

}
