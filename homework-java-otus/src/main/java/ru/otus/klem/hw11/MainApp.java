package ru.otus.klem.hw11;

import ru.otus.klem.hw11.animals.Cat;
import ru.otus.klem.hw11.animals.Dog;
import ru.otus.klem.hw11.animals.Horse;

//Создайте классы Cat, Dog и Horse с наследованием от класса Animal
//У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)
//Затраты выносливости:
//Все животные на 1 метр бега тратят 1 ед выносливости,
//Собаки на 1 метр плавания - 2 ед.
//Лошади на 1 метр плавания тратят 4 единицы
//Кот плавать не умеет.
//Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время, затраченное на указанное действие,
//и “понижать выносливость” животного. Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости.
//При выполнении действий пишем сообщения в консоль.
//Добавляем метод info(), который выводит в консоль состояние животного.
public class MainApp {
    public static void main(String[] args) {
        int distance = 250;
        Cat cat = new Cat("Tom", 10, 0, 300, true, 0);
        Dog dog = new Dog("Spike", 8, 6, 400, true, 2);
        Horse horse = new Horse("Tornado", 15, 2, 600, true, 4);

        cat.run(distance);
        cat.info();
        cat.run(distance);
        cat.swim(distance);
        cat.info();
        dog.run(distance);
        dog.info();
        dog.swim(distance);
        dog.info();
        horse.run(distance);
        horse.info();
        horse.swim(distance);
        horse.info();
    }
}
