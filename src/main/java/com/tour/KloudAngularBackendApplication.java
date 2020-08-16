package com.tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.tour.model.TouristPlace;
import com.tour.service.TouristPlaceService;

@SpringBootApplication
@ComponentScan("com")

public class KloudAngularBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(KloudAngularBackendApplication.class, args);
	}
	@Autowired
	TouristPlaceService tpService;
	//Integer id;
//	String name;
//	String description;
//	String location;
//	String city;
//	String state;
//	double distance;
	@Override
	public void run(String... args) throws Exception {
//		TouristPlace tp=new TouristPlace(1,"Kachnar City","Lord Shiva Temple","Vijay Nagar","Jabalpur","MP",200);
//		tpService.AddTouristPlace(tp);
		List<TouristPlace>list= tpService.getTouristPlaceByName("Kachnar City");
		System.out.println(list);
		List<TouristPlace>clist= tpService.getTouristPlaceByCity("Jabalpur");
		System.out.println(clist);
	}

}
