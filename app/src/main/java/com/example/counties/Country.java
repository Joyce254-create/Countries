package com.example.counties;

/**
 * @deprecated Use {@link County} instead.
 */
@Deprecated
public class Country extends County {
    public Country(String code, String name, String capital, String iconEmoji, String population, String region, String mainEconomy, String description) {
        super(code, name, capital, iconEmoji, population, region, mainEconomy, description);
    }
}