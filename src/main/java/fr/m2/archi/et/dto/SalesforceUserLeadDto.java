package fr.m2.archi.et.dto;

import fr.m2.archi.et.model.SalesforceUserModel;

public class SalesforceUserLeadDto {
	private SalesforceUserModel informations;
	
	public SalesforceUserLeadDto(SalesforceUserModel informations) {
		this.informations = informations;
	}
	
	public SalesforceUserModel getInformations() {
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
