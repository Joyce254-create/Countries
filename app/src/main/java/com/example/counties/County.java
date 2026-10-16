package com.example.counties;

import java.io.Serializable;

public class County implements Serializable {
    private final String code;
    private final String name;
    private final String capital;
    private final String iconEmoji;
    private final String population;
    private final String region;
    private final String mainEconomy;
    private final String description;

    public County(String code, String name, String capital, String iconEmoji, String population, String region, String mainEconomy, String description) {
        this.code = code;
        this.name = name;
        this.capital = capital;
        this.iconEmoji = iconEmoji;
        this.population = population;
        this.region = region;
        this.mainEconomy = mainEconomy;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getIconEmoji() {
        return iconEmoji;
    }

    public String getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }

    public String getMainEconomy() {
        return mainEconomy;
    }

    public String getDescription() {
        return description;
    }
}