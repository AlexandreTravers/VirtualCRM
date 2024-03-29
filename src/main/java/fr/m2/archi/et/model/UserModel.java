package fr.m2.archi.et.model;

public class UserModel {
	private String firstName;
	private String lastName;
	private double annualRevenue;
	private String phone;
	private String street;
	private String postalCode;
	private String city;
	private String country;
	private String creationDate;
	private String company;
	private String state;
		
	public UserModel(String firstName,
					 String lastName,
					 double annualRevenue,
					 String phone,
					 String street,
					 String postalCode,
					 String city,
					 String country,
					 String creationDate,
					 String company,
					 String state) {
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	@Override
	public String toString() {
		return firstName + " - " + lastName + " - " + annualRevenue + " - " + phone + " - " + street + " - " + postalCode + " - " + city + " - " + country + " - " + creationDate + " - " + company + " - " + state; 
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getAnnualRevenue() {
		return annualRevenue;
	}

	public String getPhone() {
		return phone;
	}

	public String getStreet() {
		return street;
	}

	public String getPostalCode() {
		return postalCode;
	}
	
	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getCompany() {
		return company;
	}

	public String getState() {
		return state;
	}
	
	public boolean isEqual(UserModel userModel) {
		if(this.firstName.equals(userModel.firstName)
		   && this.lastName.equals(userModel.lastName)
		   && this.annualRevenue == userModel.annualRevenue
		   && this.phone.equals(userModel.phone)
		   && this.street.equals(userModel.street)
		   && this.postalCode.equals(userModel.postalCode)
		   && this.city.equals(userModel.city)
		   && this.country.equals(userModel.country)
		   && this.creationDate.equals(userModel.creationDate)
		   && this.company.equals(userModel.company)
		   && this.state.equals(userModel.state)
		   ) return true;
		return false;
	}
}
