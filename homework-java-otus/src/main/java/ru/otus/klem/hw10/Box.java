package ru.otus.klem.hw10;

public class Box {
    private final int sizeX;
    private final int sizeY;
    private String color;
    private boolean boxCondition;
    private String item;

    public Box(int sizeX, int sizeY, String color, boolean boxCondition, String item) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.color = color;
        this.boxCondition = boxCondition;
        this.item = item;
    }

    public void setColor(String color) {
        this.color = color;
        System.out.println("Установлен цвет коробки: " + color);
    }

    public void setBoxCondition(boolean boxCondition) {
        this.boxCondition = boxCondition;
    }

    public void setItem(String item) {
        if (this.boxCondition) {
            if (this.item.isEmpty()) {
                this.item = item;
                System.out.println("В коробку добавлен " + item);
            } else {
                System.out.println("В коробке уже есть " + this.item + " , положить " + item + " нельзя");
            }
        } else {
            System.out.println("Коробка закрыта, положить нельзя");
        }

    }

    public void info() {
        System.out.println("размеры коробки: " + sizeX + "X" + sizeY + ", цвет: " + color);
        if (item.isEmpty()) {
            System.out.println("В коробке пусто");
        } else {
            System.out.println("В коробке находится: " + item);
        }
        if (boxCondition) {
            System.out.println("коробка открыта");
        } else {
            System.out.println("коробка закрыта");
        }
    }

    public void delItem() {
        if (this.boxCondition) {
            if (item.isEmpty()) {
                System.out.println("Удалять нечего");
            } else {
                this.item = "";
                System.out.println("Коробка очищена");
            }
        } else {
            System.out.println("Коробка закрыта, выкинуть нельзя");
        }
    }
}
