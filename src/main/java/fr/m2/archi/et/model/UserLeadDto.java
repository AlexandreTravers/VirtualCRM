package fr.m2.archi.et.model;

public class UserLeadDto {
	UserModel informations;
	
	public UserLeadDto(UserModel informations) {
		this.informations = informations;
	}
	
	public UserModel getInformations() {
		return this.informations;
	}
	
	@Override
	public String toString() {
		return this.informations.toString();
	}
}
