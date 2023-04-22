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
public class City extends BaseEntity {
	

	@Column(name="population")
	private long population;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private Country country;
	
	@JsonIgnore
	private long idOfCountry; 

	public City() {}


	public City(long id, String name, String region, long population, Country country,long idOfCountry) {
		super();
		this.population = population;
		this.country = country;
	}
	
	public long getIdOfCountry() {
		return idOfCountry;
	}

	public void setIdOfCountry(long idOfCountry) {
		this.idOfCountry = idOfCountry;
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
