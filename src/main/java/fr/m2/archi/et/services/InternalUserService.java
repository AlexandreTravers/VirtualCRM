package fr.m2.archi.et.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.m2.archi.et.model.UserLeadDto;
import fr.m2.archi.et.model.UserModel;

public class InternalUserService implements UserService {
	private final static int INTERNAL_SERVER_PORT = 8080;
	private final static String API_URL = "http://localhost:" + INTERNAL_SERVER_PORT + "/api";
	
	private static InternalUserService internalUserService;
	
	private InternalUserService() {}
	
	public static InternalUserService getInstance() {
		if(internalUserService == null) {
			internalUserService = new InternalUserService();
		}
		return internalUserService;
	}

	@Override
	public List<UserLeadDto> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserLeadDto> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
		String requestUrl = API_URL + "/getLeads";
		String requestBody = "{ \"lowAnnualRevenue\":\"" + lowAnnualRevenue + "\", \"highAnnualRevenue\":\"" + highAnnualRevenue + "\", \"state\":\"" + state + "\" }";
		
		HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = null;
        JsonNode jsonObject = null;
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
		
		List<UserLeadDto> lists = new ArrayList<>();
		if(response != null) {
			try {
				lists = jsonToLead(response.body());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return lists;
	}

	@Override
	public List<UserLeadDto> findLeadsByDate(String startDate, String enDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLead(UserLeadDto user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLead(UserLeadDto user) {
		// TODO Auto-generated method stub
		
	}
	
	private List<UserLeadDto> jsonToLead(String response) throws JsonProcessingException, IllegalArgumentException {
		List<UserLeadDto> userLeadDtos = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response);

        for (JsonNode node : jsonNode) {
            UserLeadDto userLeadDto = objectMapper.treeToValue(node, UserLeadDto.class);
            userLeadDtos.add(userLeadDto);
        }

        return userLeadDtos;
	}

}
