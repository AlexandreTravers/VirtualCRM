package fr.m2.archi.et.services.finds;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.m2.archi.et.dto.InternalUserLeadDto;
import fr.m2.archi.et.model.InternalUserModel;

public class InternalUserFinds {
	private static InternalUserFinds instance;
	private final static int INTERNAL_SERVER_PORT = 8080;
	private final static String API_URL = "http://localhost:" + INTERNAL_SERVER_PORT + "/api";
	
	private InternalUserFinds() {}
	
	public static InternalUserFinds getInstance() {
		if(instance == null) {
			instance = new InternalUserFinds();
		}
		return instance;
	}
	
	public List<InternalUserLeadDto> getUsers() {
		List<InternalUserLeadDto> test = new ArrayList<InternalUserLeadDto>();
		test.add(new InternalUserLeadDto(new InternalUserModel("Test, Test", 0, "060606", "boulevard Lavoisier", "49100", "Angers", "France", "18-12-2020", "Univ", "Maine-et-Loire")));
		return test;
	}
	
	public List<InternalUserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		String requestUrl = API_URL + "/getLeads";
		String requestBody = "{ \"lowAnnualRevenue\":\"" + lowAnnualRevenue + "\", \"highAnnualRevenue\":\"" + highAnnualRevenue + "\", \"state\":\"" + state + "\" }";
		
		HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        //JsonNode jsonObject = null;
		try {
			HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUrl))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<InternalUserLeadDto> lists = new ArrayList<>();
		if(response != null) {
			try {
				lists = jsonToLead(response.body());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return lists;
	}
	
	public List<InternalUserLeadDto> findLeadsByDate(String startDate, String endDate) {
		//TODO
		return null;
	}
	
	private List<InternalUserLeadDto> jsonToLead(String response) throws JsonProcessingException, IllegalArgumentException {
		List<InternalUserLeadDto> userLeadDtos = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response);

        for (JsonNode node : jsonNode) {
            InternalUserLeadDto userLeadDto = objectMapper.treeToValue(node, InternalUserLeadDto.class);
            userLeadDtos.add(userLeadDto);
        }

        return userLeadDtos;
	}

}
