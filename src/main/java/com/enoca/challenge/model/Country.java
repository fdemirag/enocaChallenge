package com.enoca.challenge.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="countries")
public class Country extends BaseEntity{
	
	

	@Column(name="countrycode")
	private String countrycode;
	
	
	
	
	
	 @OneToMany(mappedBy = "country",fetch=FetchType.EAGER)
	    private List<City> city;
	
	
	public Country() {}

	public Country(long id, String name, String region, String countrycode, List<City> city) {
		super();
		this.countrycode = countrycode;
		this.city = city;
	}



	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}
	
	
}
