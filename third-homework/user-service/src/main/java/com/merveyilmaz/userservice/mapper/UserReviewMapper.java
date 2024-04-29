package com.merveyilmaz.userservice.mapper;

import com.merveyilmaz.userservice.dto.ProductDTO;
import com.merveyilmaz.userservice.dto.UserReviewDTO;
import com.merveyilmaz.userservice.entitiy.User;
import com.merveyilmaz.userservice.entitiy.UserReview;
import com.merveyilmaz.userservice.request.UserReviewSaveRequest;
import com.merveyilmaz.userservice.response.UserReviewDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserReviewMapper {

    UserReviewMapper INSTANCE = Mappers.getMapper(UserReviewMapper.class);
    UserReview convertToUserReview(UserReviewSaveRequest request);
    UserReviewDTO convertToUserReviewDTO(UserReview userReview);
    List<UserReviewDTO> convertToUserReviewDTOs(List<UserReview> userReviews);

    default UserReviewDetailDTO convertToUserReviewDetailDTO(UserReview userReview, User user, ProductDTO productDTO) {

        if (userReview == null || productDTO == null || user == null) {
            return null;
        }

        return new UserReviewDetailDTO(
                userReview.getId(),
                userReview.getUserId(),
                user.getName(),
                user.getSurname(),
                user.getName() + " " + user.getSurname(),
                userReview.getProductId(),
                productDTO.name(),
                productDTO.categoryId(),
                productDTO.categoryName()
        );

    }

}
