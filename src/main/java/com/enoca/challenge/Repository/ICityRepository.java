package com.enoca.challenge.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enoca.challenge.model.City;

public interface ICityRepository extends JpaRepository<City, Long>{
	public List<City> findByNameContaining(String name);
}
