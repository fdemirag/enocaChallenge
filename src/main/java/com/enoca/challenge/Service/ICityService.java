package com.enoca.challenge.Service;

import java.util.List;

import com.enoca.challenge.model.City;

public interface ICityService {
	List<City> getAllCities();
	City getCityById(long id);
	City updateCity(City city,long id);
	City saveCity(City city);
	void deleteCity(long id);
	List<City> getByNameContaining(String name);

}
