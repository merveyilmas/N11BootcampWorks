package com.merveyilmaz.weatherapi.response;

import com.merveyilmaz.weatherapi.dto.WeatherInfoDTO;
import com.merveyilmaz.weatherapi.dto.WeatherLocationDTO;

import java.util.List;

public record WeatherResponse(WeatherLocationDTO weatherLocationDTO,
                              List<WeatherInfoDTO> weatherInfoDTOS) {
}
