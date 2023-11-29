package fr.m2.archi.et.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLeadDto {
	UserModel informations;
	
	@JsonCreator
	public UserLeadDto(@JsonProperty("informations") UserModel informations) {
		this.informations = informations;
	}
	
	public UserModel getInformations() {
		return this.informations;
	}
	
	@Override
	public String toString() {
		return this.informations.toString();
	}
	
	public boolean isEqual(UserLeadDto userLeadDto) {
		return this.informations.isEqual(userLeadDto.informations);
	}
}
