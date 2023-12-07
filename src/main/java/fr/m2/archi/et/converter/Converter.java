package fr.m2.archi.et.converter;

import fr.m2.archi.et.model.InternalUserModel;
import fr.m2.archi.et.model.SalesforceUserModel;
import fr.m2.archi.et.model.UserModel;

public class Converter {
	public static UserModel convert(InternalUserModel internalUserModel) {
		String[] name = internalUserModel.getName().split(",");
		String firstName = name[0];
		String lastName = name[1];
		double annualRevenue = internalUserModel.getAnnualRevenue();
		String phone = internalUserModel.getPhone();
		String street = internalUserModel.getStreet();
		String postalCode = internalUserModel.getPostalCode();
		String city = internalUserModel.getCity();
		String country = internalUserModel.getCountry();
		String creationDate = internalUserModel.getCreationDate();
		String company = internalUserModel.getCompany();
		String state = internalUserModel.getState();
		
		return new UserModel(firstName, lastName, annualRevenue, phone, street, postalCode, city, country, creationDate, company, state);
	}
	
	public static UserModel convert(SalesforceUserModel salesforceUserModel) {
		String firstName = salesforceUserModel.getFirstName();
		String lastName = salesforceUserModel.getLastName();
		double annualRevenue = salesforceUserModel.getAnnualRevenue();
		String phone = salesforceUserModel.getPhone();
		String street = salesforceUserModel.getStreet();
		String postalCode = salesforceUserModel.getPostalCode();
		String city = salesforceUserModel.getCity();
		String country = salesforceUserModel.getCountry();
		String creationDate = salesforceUserModel.getCreationDate();
		String company = salesforceUserModel.getCompany();
		String state = salesforceUserModel.getState();
		
		return new UserModel(firstName, lastName, annualRevenue, phone, street, postalCode, city, country, creationDate, company, state);
	}
}
