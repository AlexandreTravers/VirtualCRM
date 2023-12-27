package fr.m2.archi.et.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class GeographicPointService {

	public static JsonNode getInformations(String country, String city, String street, String postalCode) {
        // Paramètres de l'URL
        city = city.replace(" ", "+");
        country = country.replace(" ", "+");
        street = street.replace(" ", "+");
        String format = "json";
        int limit = 1;

        // Construction de l'URL
        String url = String.format("https://nominatim.openstreetmap.org/search?city=%s&country=%s&postalcode=%s&street=%s&format=%s&limit=%d",
                city, country, postalCode, street, format, limit);

        // Utilisation de HttpClient pour effectuer la requête
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        
        ObjectNode resultNode = null;

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.body());

            String latitude;
            try {
                latitude = jsonNode.get(0).get("lat").asText();
            }
            catch(Exception e)
            {
                latitude = "Unkown";
            }

            String longitude;
            try {
                longitude = jsonNode.get(0).get("lon").asText();
            }
            catch(Exception e)
            {
                longitude = "Unkown";
            }

            resultNode = objectMapper.createObjectNode();

            resultNode.put("latitude", latitude);
            resultNode.put("longitude", longitude);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultNode;
    }
}
