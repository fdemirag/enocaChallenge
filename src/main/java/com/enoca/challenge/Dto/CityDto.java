package com.enoca.challenge.Dto;

import java.util.Set;

import com.enoca.challenge.model.BaseEntity;
import com.enoca.challenge.model.City;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CityDto  extends BaseDto{
	
	
	private long population;
	
	@JsonIgnore
	private CountryDto country;
	
	private long idOfCountry;
	
	public long getIdOfCountry() {
		return idOfCountry;
	}

	public void setIdOfCountry(long idOfCountry) {
		this.idOfCountry = idOfCountry;
	}

	public CountryDto getCountry() {
		return country;
	}

	public void setCountry(CountryDto country) {
		this.country = country;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}


	
	
}
