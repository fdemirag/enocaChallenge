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

import com.enoca.challenge.ServiceImpl.CityService;
import com.enoca.challenge.model.City;

@RestController
@RequestMapping("/api/cities/")

public class CityController {
		@Autowired
		private CityService cityService;
	 

		public CityController(CityService cityService) {
			super();
			this.cityService = cityService;
		}
		
		@PostMapping("create")
		public City saveCity(@RequestBody City city) {
			return cityService.saveCity(city);
		}
		
		@GetMapping("getAll")
		public List<City> getAllCities(City city) {
			return cityService.getAllCities();
		}
		@DeleteMapping("Delete/{id}")
				public void deleteCity(@PathVariable long id) { 
			    cityService.deleteCity(id);
		}
		
		@PutMapping("update/{id}")
		public City updateCity(@RequestBody long id, @PathVariable City city) {
			return cityService.updateCity(city, id);
			
		}
		@GetMapping("getName/{name}")
		public List <City> getByNameContaining(@PathVariable String name){
			return cityService.getByNameContaining(name); 
			
		}
		@GetMapping("get/{id}")
		public City getCityById(@PathVariable long id) { 
			return cityService.getCityById(id);
		}
			
		
		
		
	
		

}
