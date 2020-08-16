package com.tour.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tour.exception.PlaceNotFoundException;
import com.tour.model.TouristPlace;
import com.tour.service.TouristPlaceService;



@RestController
//@CrossOrigin(origins="http://127.0.0.1:5500")
@CrossOrigin(origins="http://localhost:4200")
public class TouristPlaceController {
	
	@Autowired
	TouristPlaceService tpService;
	
	@GetMapping("/touristplaces")
	public ResponseEntity<List<TouristPlace>> getAllPlaces() {
		List<TouristPlace> tpList = tpService.getAllPlaces();
		return ResponseEntity.ok(tpList) ;
	}	
	@GetMapping("/place-by-name/{name}")
	public ResponseEntity<List<TouristPlace>> getTouristPlaceByCategory(@PathVariable("name")String name) throws PlaceNotFoundException
	{
		List<TouristPlace> TouristPlaceList=tpService.getTouristPlaceByName(name);
		HttpHeaders http= new HttpHeaders();
		http.add("desc", "Getting details");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(http).body(TouristPlaceList);
	}
	@GetMapping("/place-by-location/{location}")
	public ResponseEntity<List<TouristPlace>> getTouristPlaceByLocation(@PathVariable("location")String location) throws PlaceNotFoundException
	{
		List<TouristPlace> TouristPlaceList=tpService.getTouristPlaceByLocation(location);
		HttpHeaders http= new HttpHeaders();
		http.add("desc", "Getting details");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(http).body(TouristPlaceList);
	}
	
	@GetMapping("/place-by-city/{city}")
	public  ResponseEntity<List<TouristPlace>> getTouristPlaceByCity(@PathVariable("city")String city) throws PlaceNotFoundException {
		List <TouristPlace> TouristPlaceList = tpService.getTouristPlaceByCity(city);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Getting TouristPlaces by TouristPlaceid");
		header.add("content", "TouristPlace data");
		return ResponseEntity.status(HttpStatus.CREATED).headers(header).body(TouristPlaceList);
	}
	
	@GetMapping("/place-by-state/{state}")
	public  ResponseEntity<List<TouristPlace>> getTouristPlaceByState(@PathVariable("state")String state) throws PlaceNotFoundException {
		List <TouristPlace> TouristPlaceList = tpService.getTouristPlaceByState(state);
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Getting TouristPlaces by TouristPlaceid");
		header.add("content", "TouristPlace data");
		return ResponseEntity.status(HttpStatus.CREATED).headers(header).body(TouristPlaceList);
	}
	
	@PostMapping("/add")
	//@PostMapping(value = "/add", consumes=MediaType.APPLICATION_JSON_VALUE,
	//		produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addTouristPlace(@RequestBody TouristPlace TouristPlace) {
		tpService.AddTouristPlace(TouristPlace);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


	@DeleteMapping("/delete-TouristPlace/{id}")  
	public ResponseEntity<Boolean> deleteTouristPlace(@PathVariable("id") int id) throws PlaceNotFoundException {
		tpService.deletePlace(id);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
}
//
//    
//	@ExceptionHandler(TouristPlaceNotFoundException.class)
//	public ResponseEntity<String> handleIdException(TouristPlaceNotFoundException e){
//		String message=  e.getMessage();
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found");
//	}
