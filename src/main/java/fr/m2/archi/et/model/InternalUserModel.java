package fr.m2.archi.et.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InternalUserModel {
	private String name;
	private double annualRevenue;
	private String phone;
	private String street;
	private String postalCode;
	private String city;
	private String country;
	private String creationDate;
	private String company;
	private String state;
	
	@JsonCreator
	public InternalUserModel(
			 @JsonProperty("name") String name,
			 @JsonProperty("annualRevenue") double annualRevenue,
			 @JsonProperty("phone") String phone,
			 @JsonProperty("street") String street,
			 @JsonProperty("postalCode") String postalCode,
			 @JsonProperty("city") String city,
			 @JsonProperty("country") String country,
			 @JsonProperty("creationDate") String creationDate,
			 @JsonProperty("company") String company,
			 @JsonProperty("state") String state)  {
		this.name = name;
		this.annualRevenue = annualRevenue;
		this.phone = phone;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
		this.creationDate = creationDate;
		this.company = company;
		this.state = state;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getAnnualRevenue() {
		return annualRevenue;
	}


	public void setAnnualRevenue(double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	

}
