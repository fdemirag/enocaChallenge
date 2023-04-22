package com.enoca.challenge.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.challenge.Dto.CityDto;
import com.enoca.challenge.Dto.CountryDto;
import com.enoca.challenge.Exception.ResourceNotFoundException;
import com.enoca.challenge.Repository.ICityRepository;
import com.enoca.challenge.Repository.ICountryRepository;
import com.enoca.challenge.Service.ICityService;
import com.enoca.challenge.Service.ICountryService;
import com.enoca.challenge.model.City;
import com.enoca.challenge.model.Country;
@Service
public class CityService implements ICityService{
	

	@Autowired
	private ICityRepository cityRepository;
	
	@Autowired
	private ICountryRepository countryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private CityDto convertToDto(City city) {
		CityDto cityDto = modelMapper.map(city, CityDto.class);
		return cityDto;
	}
	
	private City convertToEntity(CityDto cityDto) {
	    City city = modelMapper.map(cityDto, City.class);
	    Country country = countryRepository.findById(cityDto.getIdOfCountry()).orElseThrow(() -> new ResourceNotFoundException("Country Id:"+ cityDto.getIdOfCountry()));
	    city.setCountry(country);
	    return city;
	}

	
	private Country convertToEntityCountry(CountryDto countryDto) {
	    if (countryDto == null) {
	        return null;
	    }
	    Country country = modelMapper.map(countryDto, Country.class);
	    return country;
	}

	@Override
	public List<CityDto> getAllCities() {
		List<City> cities = cityRepository.findAll();
		return cities.stream().map(this::convertToDto).collect(Collectors.toList());
	}
	
	@Override
	public CityDto getCityById(long id) {
		City city = cityRepository.findById(id).orElseThrow(() ->  
		new ResourceNotFoundException("City Id:"+ id));
		return convertToDto(city);
	}

	@Override
	public CityDto updateCity(CityDto cityDto, long id) {
		City city = cityRepository.findById(id).orElseThrow(() ->  
		new ResourceNotFoundException("City Id:"+ id));
		city.setName(cityDto.getName());
		city.setPopulation(cityDto.getPopulation());
		city.setRegion(cityDto.getRegion());
		City updatedCity = cityRepository.save(city);
		return convertToDto(updatedCity);
	}

	@Override
	public CityDto saveCity(CityDto cityDto) {
	    City city = convertToEntity(cityDto);
	    Country country = convertToEntityCountry(cityDto.getCountry());
	    if (country != null) {
	        city.setCountry(country);
	    }
	    City savedCity = cityRepository.save(city);
	    return convertToDto(savedCity);
	}


	public void deleteCity(long id) {
	    City city = cityRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Id bulunamadı"+"City Id:"+ id));
	    cityRepository.delete(city);
	}


	@Override
	public List<CityDto> getByNameContaining(String name) {
		List<City> cities = cityRepository.findByNameContaining(name);
		return cities.stream().map(this::convertToDto).collect(Collectors.toList());
	}
}
