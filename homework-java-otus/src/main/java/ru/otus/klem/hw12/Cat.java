package ru.otus.klem.hw12;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }

    public void eat(Plate plate) {
        satiety = plate.decrease(appetite);
    }

    @Override
    public String toString() {
        if (satiety) {
            return name + " поел и теперь сыт";
        } else {
            return "Кот " + name + " не тронул еду, еды мало для насыщения, остался голоден";
        }
    }

}
