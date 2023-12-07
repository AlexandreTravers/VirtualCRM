package fr.m2.archi.et.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.m2.archi.et.model.InternalUserModel;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InternalUserLeadDto {
	private InternalUserModel informations;
	
	public InternalUserLeadDto(InternalUserModel informations) {
		this.informations = informations;
	}
	
	public InternalUserModel getInformations() {
		return this.informations;
	}
	
	@Override
	public String toString() {
		return this.informations.toString();
	}
	
	/*
	public boolean isEqual(UserLeadDto userLeadDto) {
		return this.informations.isEqual(userLeadDto.informations);
	}
	*/
}
