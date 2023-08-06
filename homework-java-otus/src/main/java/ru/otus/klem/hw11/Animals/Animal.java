package ru.otus.klem.hw11.Animals;

public class Animal {
    String name;
    int runningSpeed;
    int swimmingSpeed;
    int endurance;

    public Animal(String name, int runningSpeed, int swimmingSpeed, int endurance) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = swimmingSpeed;
        this.endurance = endurance;
    }

    public int run(int distance) {
        int time = distance / runningSpeed;
        endurance = endurance - distance;

        if (endurance < 0) {
            System.out.println("У " + name + " не хватило выносливости пробежать " + distance + " метров");
            return -1;
        } else {
            System.out.println(name + " пробежал дистанцию " + distance + " метров за " + time + " секунд и осталось выносливости: " + endurance);
            return time;
        }
    }

    public int swim(int distance) {
        int time = distance / runningSpeed;
        endurance = endurance - distance;
        if (endurance < 0) {
            System.out.println("У " + name + " не хватило выносливости проплыть " + distance + " метров");
            return -1;
        } else {
            System.out.println(name + " пробежал дистанцию " + distance + " метров за " + time + " секунд и осталось выносливости: " + endurance);
            return time;
        }
    }

    public void info() {
        System.out.println("Животное: " + name + " его текущая вынослисвость: " + endurance);
    }
}
