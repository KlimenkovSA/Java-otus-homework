package ru.otus.klem.hw14;

public class AppArrayDataException extends Throwable {
    public int i;
    public int j;

    AppArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;

    }
}
