package ru.otus.klem.hw13.transport;

import ru.otus.klem.hw13.Man;
import ru.otus.klem.hw13.TypeTerrain;

public class Rover implements Transport {
    private Man man;
    private final int fuel;

    public Rover(int petrol) {
        this.fuel = petrol;
    }

    @Override
    public String getNameTransport() {
        return "Вездеход";
    }

    @Override
    public boolean move(int distance, TypeTerrain typeTerrain) {
        if (typeTerrain == TypeTerrain.PLAIN && fuel >= distance) {
            return true;
        } else if (typeTerrain == TypeTerrain.SWAMP && fuel > distance) {
            return true;
        } else if (typeTerrain == TypeTerrain.FOREST && fuel > distance) {
            return true;
        } else {
            System.out.println("Кончился бензин");
            return false;
        }
    }

    @Override
    public void getIN(Man man) {
        if (this.man == null) {
            if (man.getCurrentTransport() == null) {
                man.setCurrentTransport(this);
                this.man = man;
                System.out.println(man.getName() + " сел в " + man.getCurrentTransport());
            } else {
                System.out.println(man.getName() + "уже сидит на " + man.getCurrentTransport());
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
            System.out.println(man.getName() + " не сидит на вездеходе");
        }
    }

    @Override
    public String toString() {
        return "Вездеход";
    }

}
