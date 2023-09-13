package ru.otus.klem.hw13.transport;

import ru.otus.klem.hw13.Man;
import ru.otus.klem.hw13.TypeTerrain;

public class Bicycle implements Transport {
    private Man man;

    @Override
    public String getNameTransport() {
        return "Велосипед";
    }

    @Override
    public boolean move(int distance, TypeTerrain typeTerrain) {
        return typeTerrain != TypeTerrain.SWAMP;
    }


    @Override
    public void getIN(Man man) {
        if (this.man == null) {
            if (man.getCurrentTransport() == null) {
                man.setCurrentTransport(this);
                this.man = man;
                System.out.println(man.getName() + " сел на " + man.getCurrentTransport());
            } else {
                System.out.println(man.getName() + " уже сидит на " + man.getCurrentTransport());
            }
        } else {
            System.out.println("Лошадь уже занята человеком по имени " + this.man.getName());
        }
    }

    @Override
    public void getOut(Man man) {
        if (man.equals(this.man)) {
            man.setCurrentTransport(null);
            this.man = null;
            System.out.println(man.getName() + " теперь пешком ");
        } else {
            System.out.println("Человек " + man.getName() + " не сидит на велосипеде");
        }
    }


    @Override
    public String toString() {
        return "Велосипед";
    }

}
