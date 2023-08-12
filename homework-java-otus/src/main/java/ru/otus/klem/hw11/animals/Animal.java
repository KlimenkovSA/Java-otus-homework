package ru.otus.klem.hw11.animals;

public class Animal {
    String name;
    int runningSpeed;
    int swimmingSpeed;
    int endurance;
    boolean tiredness;
    String typeAnimal;

    public Animal(String name, int runningSpeed, int swimmingSpeed, int endurance, boolean tiredness, String typeAnimal) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = swimmingSpeed;
        this.endurance = endurance;
        this.tiredness = tiredness;
        this.typeAnimal = typeAnimal;
    }

    public int run(int distance) {
        int time = distance / runningSpeed;
        endurance -= distance;

        if (endurance < 0) {
            System.out.println("У " + name + " не хватило выносливости пробежать " + distance + " метров");
            tiredness = false;
            return -1;
        } else {
            System.out.println(name + " пробежал дистанцию " + distance + " метров за " + time + " секунд и осталось выносливости: " + endurance);
            return time;
        }
    }

    public int swim(int distance, String typeAnimal) {
        if (typeAnimal.equals("cat")) {
            System.out.println(name + " не умеет плавать");
            return -1;
        }
        else if (typeAnimal.equals("dog")) {
            endurance = (endurance - distance) / 2;
        }
        else if  (typeAnimal.equals("horse")) {
            endurance = (endurance - distance) / 4;
        }
        else {
            endurance -= distance;
        }
        int time = distance / runningSpeed;
        if (endurance < 0) {
            System.out.println("У " + name + " не хватило выносливости проплыть " + distance + " метров");
            tiredness = false;
            return -1;
        } else {
            System.out.println(name + " пробежал дистанцию " + distance + " метров за " + time + " секунд и осталось выносливости: " + endurance);
            return time;
        }
    }
    public void info() {
        if (!tiredness) {
            System.out.println("Животное " + name + " устало");
        } else {
            System.out.println("Животное: " + name + " его текущая выносливость: " + endurance);
        }
    }
}
