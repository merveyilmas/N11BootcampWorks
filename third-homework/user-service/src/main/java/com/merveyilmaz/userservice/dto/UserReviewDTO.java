package com.merveyilmaz.userservice.dto;

import com.merveyilmaz.userservice.enums.EnumRate;
import jakarta.persistence.*;

public record UserReviewDTO(Long id,
                            Long userId,
                            Long productId,
                            Long orderId,
                            EnumRate rate,
                            String comment) {
}
