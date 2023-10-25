package ru.otus.klem.hw26;

import ru.otus.klem.hw26.Fruits.Fruit;

import java.util.ArrayList;
import java.util.List;


public class Box<T extends Fruit> {

    private List<T> allFriut;

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
        //return anotherBox.weight() - this.weight() < 0.0001; не работает этот вариант !
        //return this.weight() == anotherBox.weight();
        return Math.abs(anotherBox.weight() - this.weight()) < 0.0001;

    }

    public void transferTo(Box<? super T> anotherBox) {
        if (anotherBox == null || this.allFriut == null) {
            return;
        }
        anotherBox.allFriut.addAll(this.allFriut);
        this.allFriut.clear();
    }

}
