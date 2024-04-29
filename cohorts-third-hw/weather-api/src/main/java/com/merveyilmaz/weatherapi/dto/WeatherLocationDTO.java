package com.merveyilmaz.weatherapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record WeatherLocationDTO(@NotBlank String cityName,
                                 @NotBlank String region,
                                 @NotBlank String country) {
}
