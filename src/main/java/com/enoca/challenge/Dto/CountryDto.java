package com.enoca.challenge.Dto;

import java.util.List;

public class CountryDto extends BaseDto {

	
	
    private String countrycode;
    private List<CityDto> cities;

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public List<CityDto> getCities() {
        return cities;
    }

    public void setCities(List<CityDto> cities) {
        this.cities = cities;
    }
}
