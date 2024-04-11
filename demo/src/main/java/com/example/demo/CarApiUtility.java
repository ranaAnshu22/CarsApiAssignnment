package com.example.demo;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CarApiUtility {
    private final String apiKey = "S9U1jGM266wBo1Cr5Nzjag==ZO631RzxvipHFwKT";

    private String getStringOrNull(JsonObject jsonObject, String fieldName) {
        JsonElement element = jsonObject.get(fieldName);
        return element != null && !element.isJsonNull() ? element.getAsString() : null;
    }

    public List<Car> fetchCarData(String make) {
        List<Car> carList = new ArrayList<>();

        String url = String.format("https://api.api-ninjas.com/v1/cars?limit=2&model=%s", make);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-API-Key", apiKey)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON response
            JsonArray jsonArray = JsonParser.parseString(response.body()).getAsJsonArray();
            for (JsonElement element : jsonArray) {
                JsonObject jsonObject = element.getAsJsonObject();
                // Extract car information from JSON and create CarInformation object
                Car car = new Car(
                        jsonObject.get("city_mpg").getAsInt(),
                        jsonObject.get("class").getAsString(),
                        jsonObject.get("combination_mpg").getAsInt(),
                        jsonObject.get("cylinders").getAsInt(),
                        jsonObject.get("displacement").getAsDouble(),
                        jsonObject.get("drive").getAsString(),
                        jsonObject.get("fuel_type").getAsString(),
                        jsonObject.get("highway_mpg").getAsInt(),
                        jsonObject.get("make").getAsString(),
                        jsonObject.get("model").getAsString(),
                        jsonObject.get("transmission").getAsString(),
                        jsonObject.get("year").getAsInt()
                );
                carList.add(car);
            }
        } catch (Exception e) {
            System.err.println("Error fetching car models: " + e.getMessage());
        }

        return carList;
    }
}
