package com.enoca.challenge.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enoca.challenge.Dto.CountryDto;
import com.enoca.challenge.ServiceImpl.CountryService;
import com.enoca.challenge.model.Country;


@RestController 
@RequestMapping("api/countries/")
public class CountryController {

	@Autowired
	 	private CountryService countryService;

		public CountryController(CountryService countryService) {
			super();
			this.countryService = countryService;
		}
	 	
		@GetMapping("getAll")
		public List<CountryDto> getAllCountries(CountryDto country){ 
			return countryService.getAllCountries();
		}
		@GetMapping ("get/{id}")
		public CountryDto getcountryById(@PathVariable long id) {
			return countryService.getCountryById(id);
		}
		@PutMapping ("update/{id}")
			public CountryDto updateCountry(@RequestBody CountryDto country, @PathVariable long id){	
			return countryService.updateCountry(country, id);
	}
		@PostMapping("create")
		public CountryDto saveCountry(@RequestBody CountryDto country) { 
			return countryService.saveCountry(country);
		}
		@DeleteMapping("delete/{id}")
		public void deleteCountry(@PathVariable long id) {
			countryService.deleteCountry(id);
		}
		@GetMapping("getName/{name}")
		public List<CountryDto> getByNameContaining(@PathVariable String name){
			return countryService.getByNameContaining(name);
		}
		
	 	
}
