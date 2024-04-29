package com.merveyilmaz.userservice.controller.concract;

import com.merveyilmaz.userservice.request.UserReviewSaveRequest;
import com.merveyilmaz.userservice.response.UserReviewDetailDTO;

import java.util.List;

public interface UserReviewControllerContract {

    UserReviewDetailDTO save(UserReviewSaveRequest request);

    List<UserReviewDetailDTO> findAllByUserId(Long userId);

    List<UserReviewDetailDTO> findAllByProductId(Long productId);

    UserReviewDetailDTO editComment(Long id, String newComment);
}
