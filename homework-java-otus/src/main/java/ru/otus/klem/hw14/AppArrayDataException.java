package ru.otus.klem.hw14;

public class AppArrayDataException extends RuntimeException {
    public final int i;
    public final int j;

    AppArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;

    }
}
