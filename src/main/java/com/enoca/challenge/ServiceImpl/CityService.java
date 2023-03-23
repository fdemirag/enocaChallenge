package com.enoca.challenge.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deneme.demo.exception.ResourceNotFoundException;
import com.enoca.challenge.Repository.ICityRepository;
import com.enoca.challenge.Service.ICityService;
import com.enoca.challenge.model.City;
@Service
public class CityService implements ICityService{
	
	@Autowired
	private ICityRepository cityRepository;

	@Override
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@Override
	public City getCityById(long id) {
		return cityRepository.findById(id).orElseThrow(() ->  
		new ResourceNotFoundException("City Id:"+ id));
		
	}

	@Override
	public City updateCity(City city, long id) {
		City updateCity=cityRepository.findById(id).orElseThrow(() ->  
		new ResourceNotFoundException("City Id:"+ id));
		updateCity.setName(city.getName());
		updateCity.setPopulation(city.getPopulation());
		updateCity.setRegion(city.getRegion());
		return cityRepository.save(city);
	}

	@Override
	public City saveCity(City city) {
		return cityRepository.save(city);
	}

	@Override
	public void deleteCity(long id) {
		cityRepository.deleteById(id);
	}

	@Override
	public List<City> getByNameContaining(String name) {
		return cityRepository.findByNameContaining(name);
	}

}
