package ru.otus.klem.hw13.transport;

import ru.otus.klem.hw13.Man;
import ru.otus.klem.hw13.TypeTerrain;

public interface Transport {
    String getNameTransport();

    boolean move(int distance, TypeTerrain typeTerrain);

    void getIN(Man man);

    void getOut(Man man);

}
