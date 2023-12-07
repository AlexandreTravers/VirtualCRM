package fr.m2.archi.et.converter;

import fr.m2.archi.et.dto.UserLeadDto;
import fr.m2.archi.et.dto.VirtualLeadDto;
import fr.m2.archi.et.model.UserModel;

public class VirtualConverter {
	public static VirtualLeadDto convert(UserLeadDto user) {
		String firstName = user.getInformations().getFirstName();
		String lastName = user.getInformations().getLastName();
		double annualRevenue = user.getInformations().getAnnualRevenue();
		String phone = user.getInformations().getPhone();
		String street = user.getInformations().getStreet();
		String postalCode = user.getInformations().getPostalCode();
		String city = user.getInformations().getCity();
		String country = user.getInformations().getCountry();
		String creationDate = user.getInformations().getCreationDate();
		String company = user.getInformations().getCompany();
		String state = user.getInformations().getCompany();
		
		return new VirtualLeadDto(firstName, lastName, annualRevenue, phone, street, postalCode, city, country, creationDate, company, state);
	}
	
	public static UserLeadDto convert(VirtualLeadDto user) {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		double annualRevenue = user.getAnnualRevenue();
		String phone = user.getPhone();
		String street = user.getStreet();
		String postalCode = user.getPostalCode();
		String city = user.getCity();
		String country = user.getCountry();
		String creationDate = user.getCreationDate();
		String company = user.getCompany();
		String state = user.getCompany();
		
		return new UserLeadDto(new UserModel(firstName, lastName, annualRevenue, phone, street, postalCode, city, country, creationDate, company, state));
	}
}
