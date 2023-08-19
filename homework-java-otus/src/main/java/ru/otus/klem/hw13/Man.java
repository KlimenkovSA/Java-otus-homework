package ru.otus.klem.hw13;

import ru.otus.klem.hw13.transport.Car;

public class Man {
    private final String name;
    private String currentTransport;

    public Man(String name, String currentTransport) {
        this.name = name;
        this.currentTransport = currentTransport;
    }

    public String getCurrentTransport() {
        return currentTransport;
    }

    public void setCurrentTransport(String currentTransport) {
        this.currentTransport = currentTransport;
    }

    public void getTransport(Car car){


    }

    public void dismount(){

    }
    @Override
    public String toString() {
        return name + "Текущий транспорт: " + currentTransport;
    }

}
