package fr.m2.archi.et;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpRequest.BodyPublishers;

public class TestSalesforceAPI {
	private static final String KEY = "3MVG9_kZcLde7U5o7jrBfZ7.55H_Wd9mdQnTiQb4y_VMnFKiZWY7OlquULuXrnnqy2Gu9tB6D_i8lUEZt_fuX";
	private static final String SECRET_KEY = "3D56D61A346F2AD448C2CBEE7ECB256FA4473B2EE3A2DD5DEDE7782E56BB66B3";
	private static final String DOMAIN_NAME = "https://universitangers-dev-ed.develop.my.salesforce.com";
	private static final String SECURITY_TOKEN = "Yy5WQPOvB1NnxH0Q4QLTV1FZQ";
	
	
	public static void main(String[] args) {
        // Paramètres de l'URL
        String city = "angers";
        String country = "france";
        String postalCode = "49100";
        String street = "2+boulevard+de+lavoisier";
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

        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Analyse JSON avec Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(response.body());

            // Extraction de la latitude et de la longitude
            String latitude = jsonNode.get(0).get("lat").asText();
            String longitude = jsonNode.get(0).get("lon").asText();

            // Affichage des résultats
            System.out.println("Latitude: " + latitude);
            System.out.println("Longitude: " + longitude);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
