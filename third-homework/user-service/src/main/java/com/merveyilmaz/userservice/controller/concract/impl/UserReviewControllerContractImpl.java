package com.merveyilmaz.userservice.controller.concract.impl;

import com.merveyilmaz.userservice.client.ProductClient;
import com.merveyilmaz.userservice.controller.concract.UserReviewControllerContract;
import com.merveyilmaz.userservice.dto.ProductDTO;
import com.merveyilmaz.userservice.entitiy.User;
import com.merveyilmaz.userservice.entitiy.UserReview;
import com.merveyilmaz.userservice.general.RestResponse;
import com.merveyilmaz.userservice.mapper.UserReviewMapper;
import com.merveyilmaz.userservice.request.UserReviewSaveRequest;
import com.merveyilmaz.userservice.response.UserReviewDetailDTO;
import com.merveyilmaz.userservice.service.serviceEntity.UserEntityService;
import com.merveyilmaz.userservice.service.serviceEntity.UserReviewEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserReviewControllerContractImpl implements UserReviewControllerContract {

    private final UserReviewEntityService userReviewEntityService;
    private final UserEntityService userEntityService;
    private final ProductClient productClient;

    @Override
    public UserReviewDetailDTO save(UserReviewSaveRequest request) {
        UserReview userReview = UserReviewMapper.INSTANCE.convertToUserReview(request);

        userReview = userReviewEntityService.save(userReview);

        User user = userEntityService.findByIdWithControl(userReview.getUserId());

        RestResponse<ProductDTO> productDTO = productClient.getProductById(userReview.getProductId());

        return UserReviewMapper.INSTANCE.convertToUserReviewDetailDTO(userReview, user, productDTO.getData());
    }

    @Override
    public List<UserReviewDetailDTO> findAllByUserId(Long userId) {
        List<UserReview> userReviews = userReviewEntityService.findAllByUserId(userId);

        List<UserReviewDetailDTO> userReviewDetailDTOs = new ArrayList<>();

        for (UserReview userReview : userReviews) {
            User user = userEntityService.findByIdWithControl(userReview.getUserId());
            RestResponse<ProductDTO> productDTO = productClient.getProductById(userReview.getProductId());
            userReviewDetailDTOs.add(UserReviewMapper.INSTANCE.convertToUserReviewDetailDTO(userReview, user, productDTO.getData()));
        }

        return userReviewDetailDTOs;
    }

    @Override
    public List<UserReviewDetailDTO> findAllByProductId(Long productId) {
        List<UserReview> userReviews = userReviewEntityService.findAllByProductId(productId);

        List<UserReviewDetailDTO> userReviewDetailDTOs = new ArrayList<>();

        for (UserReview userReview : userReviews) {
            if (userReview.getUserId() != null) {
                User user = userEntityService.findByIdWithControl(userReview.getUserId());
                RestResponse<ProductDTO> productDTO = productClient.getProductById(userReview.getProductId());
                userReviewDetailDTOs.add(UserReviewMapper.INSTANCE.convertToUserReviewDetailDTO(userReview, user, productDTO.getData()));
            }
        }

        return userReviewDetailDTOs;
    }

    @Override
    public UserReviewDetailDTO editComment(Long id, String newComment) {
        UserReview userReview = userReviewEntityService.findByIdWithControl(id);

        userReview.setComment(newComment);
        userReviewEntityService.save(userReview);

        User user = null;
        RestResponse<ProductDTO> productDTO = null;

        if (userReview.getUserId() != null && userReview.getProductId() != null) {
            user = userEntityService.findByIdWithControl(userReview.getUserId());
            productDTO = productClient.getProductById(userReview.getProductId());

            return UserReviewMapper.INSTANCE.convertToUserReviewDetailDTO(userReview, user, productDTO.getData());
        } else {
            return null;
        }
    }
}
