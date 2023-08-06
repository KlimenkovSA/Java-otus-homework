package ru.otus.klem.hw11.Animals;

public class Dog extends Animal {
    public Dog(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(name, runningSpeed, swimmingSpeed, endurance);
    }

    @Override
    public int swim(int distance) {
        int time = distance / runningSpeed;
        endurance = (endurance - distance) / 2;

        if (endurance < 0) {
            System.out.println("У " + name + " не хватило выносливости проплыть " + distance + " метров");
            return -1;
        } else {
            System.out.println(name + " пробежал дистанцию " + distance + " метров за " + time + " секунд и осталось выносливости: " + endurance);
            return time;
        }
    }
}
