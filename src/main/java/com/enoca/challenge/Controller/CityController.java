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

import com.enoca.challenge.Dto.CityDto;
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
		public CityDto saveCity(@RequestBody CityDto city) {
			return cityService.saveCity(city);
		}
		
		@GetMapping("getAll")
		public List<CityDto> getAllCities(CityDto city) {
			return cityService.getAllCities();
		}
		
		@DeleteMapping("delete/{id}")
				public void deleteCity(@PathVariable long id) { 
			    cityService.deleteCity(id);
		}
		
		@PutMapping("update/{id}")
		public CityDto updateCity(@PathVariable long id,@RequestBody CityDto city) {
			return cityService.updateCity(city, id);
			
		}
		@GetMapping("getName/{name}")
		public List <CityDto> getByNameContaining(@PathVariable String name){
			return cityService.getByNameContaining(name); 
			
		}
		@GetMapping("get/{id}")
		public CityDto getCityById(@PathVariable long id) { 
			return cityService.getCityById(id);
		}
			
		
		
		
	
		

}
