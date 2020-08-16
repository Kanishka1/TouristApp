package com.tour.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tour.model.TouristPlace;


public interface TouristPlaceRepository extends MongoRepository<TouristPlace, Integer> {
//	//@Query("{'touristplace.name':?0}")
//	List<TouristPlace>FindByName(String name);
//	@Query("{'TouristPlace.location':?0}")
//	List<TouristPlace>FindByLocation(String name);
//	@Query("{'TouristPlace.city':?0}")
//	List<TouristPlace>FindByCity(String name);
	
	List<TouristPlace>findByName(String name);
	List<TouristPlace>findByLocation(String name);
	List<TouristPlace>findByCity(String name);
	List<TouristPlace>findByState(String state);
}
