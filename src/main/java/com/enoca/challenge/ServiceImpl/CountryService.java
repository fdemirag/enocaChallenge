package com.enoca.challenge.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deneme.demo.exception.ResourceNotFoundException;
import com.enoca.challenge.Repository.ICountryRepository;
import com.enoca.challenge.Service.ICountryService;
import com.enoca.challenge.model.Country;
@Service
public class CountryService implements ICountryService{
	
	@Autowired
	private ICountryRepository countryRepository;
	

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public Country getcountryById(long id) {
		return countryRepository.findById(id).orElseThrow(() ->  
		new ResourceNotFoundException("Country Id:"+ id));

	}

	@Override
	public Country updateCountry(Country country, long id) {
		Country updateCountry=countryRepository.findById(id).orElseThrow(() ->
		new ResourceNotFoundException("Country Id: "+ id ));
		updateCountry.setCountrycode(country.getCountrycode());
		updateCountry.setRegion(country.getRegion());
		updateCountry.setName(country.getName());
		return countryRepository.save(country);
	}

	@Override
	public Country saveCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public void deleteCountry(long id) {
		countryRepository.deleteById(id);
	}

	@Override
	public List<Country> getByNameContaining(String name) {
		return countryRepository.findByNameContaining(name);
	}

}
