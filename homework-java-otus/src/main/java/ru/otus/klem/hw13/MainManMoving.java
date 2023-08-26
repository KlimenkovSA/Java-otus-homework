package ru.otus.klem.hw13;

import ru.otus.klem.hw13.transport.Bicycle;
import ru.otus.klem.hw13.transport.Car;
import ru.otus.klem.hw13.transport.Horse;
import ru.otus.klem.hw13.transport.Rover;

//Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
//Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход
//Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
//В приложении должны быть типы местности: густой лес, равнина, болото
//Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него, или переместиться на некоторое расстояние (при условии что он находится на каком-либо транспорте)
//При попытке выполнить перемещение у человека, не использующего транспорт, считаем что он просто идет указанное расстояние пешком
//При перемещении Машина и Вездеход тратят бензин, который у них ограничен. Лошадь тратит силы. Велосипед может использоваться без ограничений (можете для усложнения велосипедом тратить силы “водителя”).
//При выполнении действия результат должен быть отпечатан в консоль
//У каждого вида транспорта есть местности по которым он не может перемещаться: машина - густой лес и болото, лошадь и велосипед - болото, вездеход - нет ограничений
//При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
public class MainManMoving {
    public static void main(String[] args) {
        Man man = new Man("Сергей");
        Bicycle bicycle = new Bicycle();
        Car car = new Car(50);
        Horse horse = new Horse(15);
        Rover rover = new Rover(200);


        man.move(10, TypeTerrain.SWAMP);
        bicycle.getIN(man);
        man.move(10, TypeTerrain.FOREST);
        man.move(10, TypeTerrain.PLAIN);
        man.move(10, TypeTerrain.SWAMP);
        horse.getIN(man);
        bicycle.getOut(man);
        horse.getIN(man);
        man.move(10, TypeTerrain.FOREST);
        man.move(20, TypeTerrain.PLAIN);
        man.move(10, TypeTerrain.SWAMP);
        horse.getOut(man);
        car.getIN(man);
        man.move(10, TypeTerrain.FOREST);
        man.move(20, TypeTerrain.PLAIN);
        man.move(100, TypeTerrain.PLAIN);
        man.move(10, TypeTerrain.SWAMP);
        car.getOut(man);
        rover.getIN(man);
        man.move(10, TypeTerrain.SWAMP);
        man.move(10, TypeTerrain.FOREST);
        man.move(300, TypeTerrain.PLAIN);


    }
}
