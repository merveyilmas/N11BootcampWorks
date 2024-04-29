package com.merveyilmaz.productservice.request;

import com.merveyilmaz.productservice.enums.EnumStatus;

import java.time.LocalDateTime;

public record ProductSaveRequest(String name,
                                 double price,
                                 LocalDateTime expirationDate,
                                 String description,
                                 Long categoryId,
                                 EnumStatus status) {

}
