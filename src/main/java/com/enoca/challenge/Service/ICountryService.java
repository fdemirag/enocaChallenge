package com.enoca.challenge.Service;

import java.util.List;

import com.enoca.challenge.Dto.CountryDto;


public interface ICountryService {
	List<CountryDto> getAllCountries();
	CountryDto getCountryById(long id);
	CountryDto updateCountry(CountryDto countryDto, long id);
	CountryDto saveCountry(CountryDto countryDto);
	void deleteCountry(long id);
	List<CountryDto> getByNameContaining(String name);

}


