package fr.m2.archi.et.services.modify;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.m2.archi.et.model.UserModel;
import fr.m2.archi.et.services.finds.SalesforceUserFinds;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Random;

public class SalesforceUserModify {

	private static final String KEY = "3MVG9_kZcLde7U5o7jrBfZ7.55H_Wd9mdQnTiQb4y_VMnFKiZWY7OlquULuXrnnqy2Gu9tB6D_i8lUEZt_fuX";
	private static final String SECRET_KEY = "3D56D61A346F2AD448C2CBEE7ECB256FA4473B2EE3A2DD5DEDE7782E56BB66B3";
	private static final String DOMAIN_NAME = "https://universitangers-dev-ed.develop.my.salesforce.com";
	private static final String SECURITY_TOKEN = "Yy5WQPOvB1NnxH0Q4QLTV1FZQ";
	private static final String LOGIN_URL = "https://login.salesforce.com/services/oauth2/token";
	private static final String USERNAME = "alexandretvs@univ-angers.fr";
	private static final String PASSWORD = "*LePlusGrandMDPJamaisVueAvant2023*";

	private static SalesforceUserModify instance;
	
	private SalesforceUserModify() {}
	
	public static SalesforceUserModify getInstance() {
		if(instance == null) {
			instance = new SalesforceUserModify();
		}
		return instance;
	}
	
	public void addUser(UserModel um) {
		String accessToken = this.getAccessToken();

		String apiUrl = DOMAIN_NAME + "/services/data/v59.0/sobjects/User";


		ObjectMapper objectMapper = new ObjectMapper();

		String mail = um.getFirstName()+"."+um.getLastName()+"@testmail.com";

		JsonNode userData = objectMapper.createObjectNode()
				.put("Username", mail)
				.put("Email", mail)
				.put("Alias", um.getFirstName().substring(0,3)+um.getLastName().substring(0,3))
				.put("TimeZoneSidKey", "Europe/Paris")
				.put("LocaleSidKey","en_US")
				.put("EmailEncodingKey","UTF-8")
				.put("LanguageLocaleKey","en_US")
				.put("ProfileId", "00e06000001aABtAAM")
				.put("FirstName", um.getFirstName())
				.put("LastName", um.getLastName())
				.put("annualRevenue__c", um.getAnnualRevenue())
				.put("Phone", um.getPhone())
				.put("CompanyName", um.getCompany())
				.put("street", um.getStreet())
				.put("postalCode", um.getPostalCode())
				.put("city", um.getCity())
				.put("country", um.getCountry())
				.put("state", um.getState());

		try
		{
			String jsonBody = objectMapper.writeValueAsString(userData);

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(apiUrl))
					.header("Authorization", "Bearer " + accessToken)
					.header("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(jsonBody))
					.build();

			HttpClient client = HttpClient.newHttpClient();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			// Afficher la réponse
			System.out.println("Response Code: " + response.statusCode());
			System.out.println("Response Body: " + response.body());

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*String query = "INSERT INTO User VALUES("
				+ "'" + um.getFirstName() + "'"
				+ "'" + um.getLastName() + "'"
				+ "'" + um.getAnnualRevenue() + "'"
				+ "'" + um.getPhone() + "'"
				+ "'" + um.getPhone() + "'"
				+ "'" + um.getFirstName() + "'"
				+ "'" + um.getFirstName() + "'"
				+ "'" + um.getFirstName() + "'"
				+ "'" + um.getFirstName() + "'"
				+ "'" + um.getFirstName() + "'"
				+ ")";

		String apiUrl = DOMAIN_NAME + "/services/data/v59.0/query/?q=SELECT+FirstName,LastName,annualRevenue__c,Phone,Address,PostalCode,Country,CreatedDate,CompanyName+FROM+User";

		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response;
		JsonNode jsonObject = null;

		try
		{
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(apiUrl))
					.header("Authorization", "Bearer " + accessToken)
					.GET()
					.build();
			response = client.send(request, HttpResponse.BodyHandlers.ofString());

		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}


	private String generateRandomNumberString(int length) {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomNumber = random.nextInt(10); // Génère un nombre aléatoire entre 0 et 9
			stringBuilder.append(randomNumber);
		}

		return stringBuilder.toString();
	}

	public void deleteUser(String phoneNumber) {
		String accessToken = this.getAccessToken();
		String apiUrl = DOMAIN_NAME + "/services/data/v59.0/users/delete";

		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response;

		String requestBody = "identityAttribute:emailAddress\nloulou.testleadd@testmail.com";


		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(apiUrl))
					.header("Content-Type", "multipart/form-data")
					.header("Authorization", "Bearer " + accessToken)
					.POST(HttpRequest.BodyPublishers.ofString(requestBody))
					.build();
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(response.body());
			int i = 0;
		}
		catch(Exception e)
		{

		}
	}

	private String getAccessToken() {
		String requestBody = "grant_type=password"
				+ "&client_id=" + KEY
				+ "&client_secret=" + SECRET_KEY
				+ "&username=" + USERNAME
				+ "&password=" + PASSWORD + SECURITY_TOKEN;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(LOGIN_URL))
				.header("Content-Type", "application/x-www-form-urlencoded")
				.POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();

		HttpResponse<String> response;
		String accessToken = "";

		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
			//System.out.println("Réponse de l'authentification : " + response.body());

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(response.body());

			accessToken = jsonNode.get("access_token").asText();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return accessToken;
	}

	private JsonNode getUsersInformationsInJSON(String filtre) {
		String accessToken = this.getAccessToken();
		String apiUrl = DOMAIN_NAME + "/services/data/v59.0/query/?q=SELECT+FirstName,LastName,annualRevenue__c,Phone,Address,PostalCode,Country,CreatedDate,CompanyName+FROM+User" + filtre;

		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> response;
		JsonNode jsonObject = null;

		try
		{
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(apiUrl))
					.header("Authorization", "Bearer " + accessToken)
					.GET()
					.build();
			response = client.send(request, HttpResponse.BodyHandlers.ofString());

			ObjectMapper objectMapper = new ObjectMapper();
			jsonObject = objectMapper.readValue(response.body(), JsonNode.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
