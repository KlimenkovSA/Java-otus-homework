package ru.otus.klem.hw26;
//Создайте классы Fruit, Apple extends Fruit, Orange extends Fruit;
//Создайте класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта: Box только для яблок, Box только для апельсин, Box и для тех, и для других фруктов.
//Для хранения фруктов внутри коробки используйте ArrayList;
//Реализуйте метод добавления фрукта в коробку;
//Реализуйте метод weight, который высчитывает вес коробки (например, из веса одного фрукта и их количества, или может через суммирование, как посчитаете нужным). Вес фрукта задаете самостоятельно, единицы измерения не важны;
//Реализуйте метод compare, позволяющий сравнить текущую коробку с переданной в качестве аргумента. true – если их массы равны. Можно сравнивать коробки с разными типами фруктов;
//Реализуйте метод, позволяющий пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов в коробках;

import ru.otus.klem.hw26.Fruits.Apple;
import ru.otus.klem.hw26.Fruits.Fruit;
import ru.otus.klem.hw26.Fruits.Orange;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();

        Box<Apple> appleBox1 = new Box<>(new ArrayList<>(List.of()));
        Box<Orange> orangeBox1 = new Box<>(new ArrayList<>(List.of()));

        appleBox1.add(apple1);
        appleBox1.add(apple2);
        appleBox1.add(apple3);
        appleBox1.add(apple4);
        appleBox1.add(apple5);
        appleBox1.add(apple6);

        System.out.println("Вес коробки с яблоками: " + appleBox1.weight());

        orangeBox1.add(orange1);
        orangeBox1.add(orange2);
        orangeBox1.add(orange3);

        //orangeBox1.add(orange4); //для равенства по весу
        System.out.println("Вес коробки с апельсинами: " + orangeBox1.weight());
        System.out.println(appleBox1.compare(orangeBox1));

        Box<Fruit> allFruit = new Box<>(new ArrayList<>(List.of()));
        orangeBox1.transferTo(allFruit);
        appleBox1.transferTo(allFruit);

        System.out.println("Вес коробки с яблоками: " + appleBox1.weight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox1.weight());
        System.out.println("Вес коробки с фруктами: " + allFruit.weight());

    }
}

