package com.enoca.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cities")
public class City {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="region")
	private String region;
	@Column(name="population")
	private long population;
	
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="country_id") 
	private Country country;
	
	
	public City() {}


	public City(long id, String name, String region, long population, Country country) {
		
		this.id = id;
		this.name = name;
		this.region = region;
		this.population = population;
		this.country = country;
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


	public long getPopulation() {
		return population;
	}


	public void setPopulation(long population) {
		this.population = population;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}
	
	
	
}
