package com.tour.service;

import java.util.List;

import com.tour.model.TouristPlace;

public interface TouristPlaceService {
	List<TouristPlace>getTouristPlaceByName(String name);
	List<TouristPlace>getTouristPlaceByLocation(String location);
	List<TouristPlace>getTouristPlaceByCity(String city);
	void AddTouristPlace(TouristPlace touristPlace);
	List<TouristPlace>getTouristPlaceByState(String state);
	 boolean deletePlace(Integer id);
	 TouristPlace updatePlace(TouristPlace place);
	    	//void AddTouristPlace(TouristPlace place);

	List<TouristPlace>getAllPlaces();

}
