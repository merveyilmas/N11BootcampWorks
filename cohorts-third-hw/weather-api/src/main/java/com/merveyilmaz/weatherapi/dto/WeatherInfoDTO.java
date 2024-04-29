package com.merveyilmaz.weatherapi.dto;

import jakarta.validation.constraints.NotBlank;

public record WeatherInfoDTO(@NotBlank String date,
                             @NotBlank String weather) {
}
