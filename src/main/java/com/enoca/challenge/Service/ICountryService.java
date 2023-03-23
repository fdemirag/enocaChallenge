package com.enoca.challenge.Service;

import java.util.List;


import com.enoca.challenge.model.Country;

public interface ICountryService {
	List<Country> getAllCountries();
	Country getcountryById(long id);
	Country updateCountry(Country Country,long id);
	Country saveCountry(Country country);
	void deleteCountry(long id);
	List<Country> getByNameContaining(String name);

}


