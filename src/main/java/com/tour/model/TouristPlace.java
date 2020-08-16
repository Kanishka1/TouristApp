package com.tour.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("touristplace")
public class TouristPlace {
	@Id
	Integer id;
	String name;
	String description;
	String location;
	String city;
	String state;
	double distance;
}