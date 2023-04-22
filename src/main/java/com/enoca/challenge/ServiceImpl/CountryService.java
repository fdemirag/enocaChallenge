package com.enoca.challenge.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.challenge.Dto.CityDto;
import com.enoca.challenge.Dto.CountryDto;
import com.enoca.challenge.Exception.ResourceNotFoundException;
import com.enoca.challenge.Repository.ICountryRepository;
import com.enoca.challenge.Service.ICountryService;
import com.enoca.challenge.model.City;
import com.enoca.challenge.model.Country;
@Service
public class CountryService implements ICountryService{
	
	@Autowired
	private ICountryRepository countryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private CountryDto convertToDto(Country country) {
	    CountryDto countryDto = modelMapper.map(country, CountryDto.class);
	    List<CityDto> cityDtos = country.getCity().stream()
	            .map(city -> modelMapper.map(city, CityDto.class))
	            .collect(Collectors.toList());
	    countryDto.setCities(cityDtos);
	    return countryDto;
	}
	

	
	private Country convertToEntity(CountryDto countryDto) {
		Country country = modelMapper.map(countryDto, Country.class);
		return country;
	}
	
	@Override
	public List<CountryDto> getAllCountries() {
		List<Country> countries = countryRepository.findAll();
		return countries.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public CountryDto getCountryById(long id) {
		Country country = countryRepository.findById(id).orElseThrow(() ->  
		new ResourceNotFoundException("Country Id:"+ id));
		return convertToDto(country);
	}

	@Override
	public CountryDto updateCountry(CountryDto countryDto, long id) {
	    Country country = countryRepository.findById(id).orElseThrow(() ->
	            new ResourceNotFoundException("Country Id:" + id));
	    country.setCountrycode(countryDto.getCountrycode());
	    country.setRegion(countryDto.getRegion());
	    country.setName(countryDto.getName());
	    
	    Country updatedCountry = countryRepository.save(country);
	    return convertToDto(updatedCountry);
	}


	@Override
	public CountryDto saveCountry(CountryDto countryDto) {
		Country country = convertToEntity(countryDto);
		Country savedCountry = countryRepository.save(country);
		return convertToDto(savedCountry);
	}

	public void deleteCountry(long id) {
    Country country = countryRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Id bulunamadı "+"Country Id:"+ id));
    countryRepository.delete(country);
}


	@Override
	public List<CountryDto> getByNameContaining(String name) {
		List<Country> countries = countryRepository.findByNameContaining(name);
		return countries.stream().map(this::convertToDto).collect(Collectors.toList());
	}

}
