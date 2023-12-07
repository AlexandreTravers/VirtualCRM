package fr.m2.archi.et.dto;

import com.fasterxml.jackson.databind.JsonNode;

import fr.m2.archi.et.services.GeographicPointService;

public class GeographicPointDto {
	private double longitude;
	private double latitude;
	
	public GeographicPointDto(String country, String city, String street, String postalCode) {
		JsonNode json = GeographicPointService.getInformations(country, city, street, postalCode);
		if(json != null) {
			longitude = json.get("longitude").asDouble();
			latitude = json.get("latitude").asDouble();
		} else {
			longitude = 0;
			latitude = 0;
		}
	}
	
	public double getLongitude() {
		return longitude;
	}
	public double getLatitude() {
		return latitude;
	}
}
