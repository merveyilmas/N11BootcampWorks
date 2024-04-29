package com.merveyilmaz.weatherapi.converter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merveyilmaz.weatherapi.dto.WeatherInfoDTO;
import com.merveyilmaz.weatherapi.dto.WeatherLocationDTO;
import com.merveyilmaz.weatherapi.exceptions.JsonProccessingException;
import com.merveyilmaz.weatherapi.general.GeneralErrorMessage;
import com.merveyilmaz.weatherapi.response.WeatherResponse;

import java.util.ArrayList;
import java.util.List;

public class WeatherObjectConverter {

    public static WeatherResponse convertToWeatherResponse(Object response){

        List<WeatherInfoDTO> weatherInfoList = new ArrayList<>();
        WeatherLocationDTO weatherLocation = null;
        ObjectMapper mapper = new ObjectMapper();

        try {

            JsonNode rootNode = mapper.readTree(mapper.writeValueAsString(response));

            String locationName = rootNode.path("location").path("name").asText();
            String locationRegion = rootNode.path("location").path("region").asText();
            String locationCountry = rootNode.path("location").path("country").asText();

            weatherLocation = new WeatherLocationDTO(locationName, locationRegion, locationCountry);

            JsonNode forecastdayNode = rootNode.path("forecast").path("forecastday");

            for (JsonNode node : forecastdayNode) {
                String date = node.path("date").asText();
                String conditionText = node.path("day").path("condition").path("text").asText();

                WeatherInfoDTO weatherInfo = new WeatherInfoDTO(date, conditionText);
                weatherInfoList.add(weatherInfo);
            }

        } catch (Exception e) {
            //e.getMessage();
            throw new JsonProccessingException(GeneralErrorMessage.JSON_PROCCESSING_ERROR);
        }

        return new WeatherResponse(weatherLocation, weatherInfoList);
    }
}
