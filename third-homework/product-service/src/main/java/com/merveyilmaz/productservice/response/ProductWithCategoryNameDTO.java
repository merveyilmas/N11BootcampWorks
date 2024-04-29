package com.merveyilmaz.productservice.response;

import com.merveyilmaz.productservice.enums.EnumStatus;

import java.time.LocalDateTime;

public record ProductWithCategoryNameDTO(Long id,
                                         String name,
                                         double price,
                                         LocalDateTime expirationDate,
                                         String description,
                                         Long categoryId,
                                         String categoryName,
                                         EnumStatus status) {
}
