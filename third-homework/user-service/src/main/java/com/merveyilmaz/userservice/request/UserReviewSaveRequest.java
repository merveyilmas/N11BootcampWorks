package com.merveyilmaz.userservice.request;

import com.merveyilmaz.userservice.enums.EnumRate;

public record UserReviewSaveRequest(Long userId,
                                    Long productId,
                                    Long orderId,
                                    EnumRate rate,
                                    String comment) {
}
