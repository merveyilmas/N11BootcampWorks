package com.merveyilmaz.userservice.dto;

import com.merveyilmaz.userservice.enums.EnumGender;
import com.merveyilmaz.userservice.enums.EnumStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserDTO(Long id,
                      String name,
                      String surname,
                      LocalDateTime userCreateDate,
                      LocalDate birthDate,
                      String email,
                      EnumGender gender,
                      EnumStatus status) {
}
