package com.merveyilmaz.weatherapi.controller;

import com.merveyilmaz.weatherapi.exceptions.JsonProccessingException;
import com.merveyilmaz.weatherapi.general.GeneralErrorMessage;
import com.merveyilmaz.weatherapi.general.RestResponse;
import com.merveyilmaz.weatherapi.converter.WeatherObjectConverter;
import com.merveyilmaz.weatherapi.response.WeatherResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.servlet.function.ServerResponse.badRequest;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    @Value("${weather-api-base-url}")
    private String BASE_URL;

    @Value("${weather-api-key}")
    private String WEATHER_API_KEY;

    @GetMapping("/daily")
    public ResponseEntity<RestResponse<WeatherResponse>> getDailyWeather(@RequestParam @NotBlank @Size(min = 2, max = 50) @Valid String cityName) {

        Map<String, String> params = new HashMap<>();
        params.put("q", cityName);
        params.put("days", "1");
        params.put("key", WEATHER_API_KEY);

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/forecast.json")
                .queryParam("days", "{days}")
                .queryParam("q", "{q}")
                .queryParam("key", "{key}")
                .buildAndExpand(params)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        Object response = restTemplate.getForObject(url, Object.class, params);

        return ResponseEntity.ok(RestResponse.of(WeatherObjectConverter.convertToWeatherResponse(response)));
    }

    @GetMapping("/weekly")
    public ResponseEntity<RestResponse<WeatherResponse>> getWeeklyWeather(@RequestParam @NotBlank @Size(min = 2, max = 50, message = "City name must be at least 2 characters long") @Valid String cityName) {

        Map<String, String> params = new HashMap<>();
        params.put("q", cityName);
        params.put("days", "7");
        params.put("key", WEATHER_API_KEY);

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/forecast.json")
                .queryParam("days", "{days}")
                .queryParam("q", "{q}")
                .queryParam("key", "{key}")
                .buildAndExpand(params)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        Object response = restTemplate.getForObject(url, Object.class, params);

        return ResponseEntity.ok(RestResponse.of(WeatherObjectConverter.convertToWeatherResponse(response)));
    }
}
