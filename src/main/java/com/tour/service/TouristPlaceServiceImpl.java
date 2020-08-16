package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.exception.PlaceNotFoundException;
import com.tour.model.TouristPlace;
import com.tour.repository.TouristPlaceRepository;
@Service
public class TouristPlaceServiceImpl implements TouristPlaceService {
@Autowired
TouristPlaceRepository tpRepository;
	@Override
	public List<TouristPlace> getTouristPlaceByName(String name) {
		List<TouristPlace> PlaceByName=tpRepository.findByName(name);
		if(PlaceByName.isEmpty())
		{
			throw new PlaceNotFoundException("Tourist Place With this name not found");
		}
		return PlaceByName;
	}

	@Override
	public List<TouristPlace> getTouristPlaceByLocation(String location) {
		List<TouristPlace> PlaceByLocation=tpRepository.findByLocation(location);
		if(PlaceByLocation.isEmpty())
		{
			throw new PlaceNotFoundException("Tourist Place With this location not found");
		}
		return PlaceByLocation;
	}

	@Override
	public List<TouristPlace> getTouristPlaceByCity(String city) {
		List<TouristPlace> PlaceByCity=tpRepository.findByCity(city);
		if(PlaceByCity.isEmpty())
		{
			throw new PlaceNotFoundException("Tourist Place With this location not found");
		}
		return PlaceByCity;
	}


	@Override
	public List<TouristPlace> getAllPlaces() {
		List<TouristPlace> AllPlaces=tpRepository.findAll();
		if(AllPlaces.isEmpty())
		{
			throw new PlaceNotFoundException("Tourist Place not found");
		}
		return AllPlaces;
	}

	@Override
	public void AddTouristPlace(TouristPlace place) {
	tpRepository.save(place);
		
	}

	@Override
	public List<TouristPlace> getTouristPlaceByState(String state) {
		List<TouristPlace> AllPlaces=tpRepository.findByState(state);
		if(AllPlaces.isEmpty())
		{
			throw new PlaceNotFoundException("Tourist Place not found");
		}
		return AllPlaces;
	
	}

	@Override
	public boolean deletePlace(Integer id) {
		tpRepository.deleteById(id);
		return true;
	}

	@Override
	public TouristPlace updatePlace(TouristPlace place) {
		return tpRepository.save(place);
	}


	
}
