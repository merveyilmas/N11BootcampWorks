package com.merveyilmaz.userservice.dto;

import com.merveyilmaz.userservice.enums.EnumStatus;

import java.time.LocalDateTime;

public record ProductDTO(Long id,
                         String name,
                         double price,
                         LocalDateTime expirationDate,
                         String description,
                         Long categoryId,
                         String categoryName,
                         EnumStatus status) {
}
