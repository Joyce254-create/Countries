package com.example.counties;

import java.util.List;

/**
 * @deprecated Use {@link CountyAdapter} instead.
 */
@Deprecated
public class CountryAdapter extends CountyAdapter {

    @Deprecated
    public interface OnCountryClickListener extends OnCountyClickListener {
        default void onCountryClick(Country country) {
            onCountyClick(country);
        }
    }

    public CountryAdapter(List<County> countyList, OnCountyClickListener clickListener) {
        super(countyList, clickListener);
    }
}