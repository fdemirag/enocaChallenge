package com.enoca.challenge.Service;

import java.util.List;

import com.enoca.challenge.Dto.CityDto;
import com.enoca.challenge.model.City;

public interface ICityService {
	List<CityDto> getAllCities();
	CityDto getCityById(long id);
	CityDto updateCity(CityDto cityDto,long id);
	CityDto saveCity(CityDto cityDto);
	void deleteCity(long id);
	List<CityDto> getByNameContaining(String name);

}
