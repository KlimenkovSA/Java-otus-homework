package ru.otus.klem.hw13;

import ru.otus.klem.hw13.transport.Transport;

public class Man {
    private final String name;

    private Transport currentTransport;


    public String getName() {
        return name;
    }

    public Man(String name) {
        this.name = name;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public void setCurrentTransport(Transport currentTransport) {
        this.currentTransport = currentTransport;
    }

    public void move(int distance, TypeTerrain typeTerrain) {
        if (this.getCurrentTransport() == null) {
            System.out.println(this.name + " прошел пешком дистанцию " + distance + " км по местности: " + typeTerrain.getNameTerrain());
        } else {
            boolean trip = currentTransport.move(distance, typeTerrain);
            if (trip) {
                System.out.println(this.name + " проехал " + distance + " км на транспорте: " + currentTransport.getNameTransport() + " , по местности: " + typeTerrain.getNameTerrain());
            } else {
                System.out.println(this.name + " не может проехать по местности: " + typeTerrain.getNameTerrain() + " на " + currentTransport.getNameTransport());
            }
        }
    }
}
