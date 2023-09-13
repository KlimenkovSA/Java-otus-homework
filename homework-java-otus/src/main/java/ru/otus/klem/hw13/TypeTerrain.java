package ru.otus.klem.hw13;

public enum TypeTerrain {
    FOREST("густой лес"), PLAIN("равнина"), SWAMP("болото");

    private final String nameTerrain;
    TypeTerrain(String nameTerrain) {
        this.nameTerrain = nameTerrain;
    }

    public String getNameTerrain() {
       return nameTerrain;
    }


}
