package ru.otus.klem.hw11.Animals;

public class Horse extends Animal {
    public Horse(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        super(name, runningSpeed, swimmingSpeed, endurance);
    }

    public int swim(int distance) {
        int time = distance / runningSpeed;
        endurance = (endurance - distance) / 4;

        if (endurance < 0) {
            System.out.println("У " + name + " не хватило выносливости проплыть " + distance + " метров");
            return -1;
        } else {
            System.out.println(name + " пробежал дистанцию " + distance + " метров за " + time + " секунд и осталось выносливости: " + endurance);
            return time;
        }
    }
}
