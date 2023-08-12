package ru.otus.klem.hw12;

public class Plate {
    private final int maxFood;
    private int currFood;

    public Plate(int maxFood, int currFood) {
        //this.volume = volume;
        this.maxFood = maxFood;
        this.currFood = currFood;
    }

    public void fill(int food) {
        currFood += food;
        if (currFood > maxFood) {
            currFood = maxFood;
            System.out.println("В тарелку не влезет столько еды, насыпано до краев");
        }
    }
    public boolean decrease(int hungry) {
        if (currFood >= hungry) {
            currFood -= hungry;
            return true;
        } else {
            System.out.println("Опреция не допустима");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Plate: " + currFood;
    }
}
