package com.merveyilmaz.secondhomework.request;

import com.merveyilmaz.secondhomework.entitiy.Category;
import com.merveyilmaz.secondhomework.enums.EnumStatus;

import java.time.LocalDateTime;

public record ProductSaveRequest(String name,
                                 double price,
                                 LocalDateTime expirationDate,
                                 String description,
                                 Category categoryId,
                                 EnumStatus status) {

}
