package com.enoca.challenge.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.enoca.challenge.model.Country;

public interface ICountryRepository extends JpaRepository<Country, Long>{
	public List<Country> findByNameContaining(String name);
}
