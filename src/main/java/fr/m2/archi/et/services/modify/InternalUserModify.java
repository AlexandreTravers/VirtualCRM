package fr.m2.archi.et.services.modify;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.m2.archi.et.dto.InternalUserLeadDto;

public class InternalUserModify {
	private static InternalUserModify instance;
	
	private InternalUserModify() {}
	
	public static InternalUserModify getInstance() {
		if(instance == null) {
			instance = new InternalUserModify();
		}
		return instance;
	}
	
	public void addUser(InternalUserLeadDto user) {
        String apiUrl = "http://localhost:8080/api/addUser";

        String jsonBody = "{ \"name\": \"" + user.getInformations().getName() + "\","
        		+ "\"annualRevenue\": \"" + user.getInformations().getAnnualRevenue() + "\","
        		+ "\"phone\": \"" + user.getInformations().getPhone() + "\","
        		+ "\"street\": \"" + user.getInformations().getStreet() + "\","
        		+ "\"postalCode\": \"" + user.getInformations().getPostalCode() + "\","
        		+ "\"city\": \"" + user.getInformations().getCity() + "\","
        		+ "\"country\": \"" + user.getInformations().getCountry() + "\","
        		+ "\"company\": \"" + user.getInformations().getCompany() + "\","
        		+ "\"state\": \"" + user.getInformations().getState() + "\""
        		+ " }";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
	}
	
	public void deleteUser(String phoneNumber) {
		String apiUrl = "http://localhost:8080/api/deleteUser";

        String jsonBody = "{ \"phoneNumber\": \"" + phoneNumber + "\" }";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
	}
}
