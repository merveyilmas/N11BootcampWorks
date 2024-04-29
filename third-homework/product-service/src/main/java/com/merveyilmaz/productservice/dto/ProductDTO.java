package com.merveyilmaz.productservice.dto;

import com.merveyilmaz.productservice.entitiy.Category;
import com.merveyilmaz.productservice.enums.EnumStatus;
import java.time.LocalDateTime;

public record ProductDTO(Long id,
                         String name,
                         double price,
                         LocalDateTime expirationDate,
                         String description,
                         Long categoryId,
                         EnumStatus status) {

}
