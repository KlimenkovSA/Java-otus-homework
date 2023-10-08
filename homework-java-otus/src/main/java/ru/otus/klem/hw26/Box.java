package ru.otus.klem.hw26;

import java.util.ArrayList;


public class Box<T extends Fruit> {

    ArrayList<T> allFriut;

    public Box(ArrayList<T> fruitList) {
        this.allFriut = fruitList;
    }

    public void add(T fruit) {
        this.allFriut.add(fruit);
    }
    public double weight() {
        if (this.allFriut.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Fruit fruit : allFriut) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> anotherBox) {
        //return anotherBox.weight() - this.weight() < 0.0001;
        return this.weight() == anotherBox.weight();

    }

    public void transferTo(Box<? super T> anotherBox) {
        anotherBox.allFriut.addAll(this.allFriut);
        this.allFriut.clear();
    }

}
