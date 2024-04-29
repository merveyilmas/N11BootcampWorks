package com.merveyilmaz.secondhomework.dto;

import com.merveyilmaz.secondhomework.entitiy.Category;
import com.merveyilmaz.secondhomework.enums.EnumStatus;
import java.time.LocalDateTime;

public record ProductDTO(Long id,
                         String name,
                         double price,
                         LocalDateTime expirationDate,
                         String description,
                         Category categoryId,
                         EnumStatus status) {

}
