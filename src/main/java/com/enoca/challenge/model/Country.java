package com.enoca.challenge.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column (name="name")
	private String name;
	@Column(name="region")
	private String region;
	@Column(name="countrycode")
	private String countrycode;
	
	
	//@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY,mappedBy="country")
	private List<City> city;
	
	
	
	
	
	public Country() {}

	public Country(long id, String name, String region, String countrycode, List<City> city) {
		
		this.id = id;
		this.name = name;
		this.region = region;
		this.countrycode = countrycode;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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
