package com.merveyilmaz.userservice.controller.concract.impl;

import com.merveyilmaz.userservice.client.ProductClient;
import com.merveyilmaz.userservice.dto.ProductDTO;
import com.merveyilmaz.userservice.entitiy.User;
import com.merveyilmaz.userservice.entitiy.UserReview;
import com.merveyilmaz.userservice.enums.EnumGender;
import com.merveyilmaz.userservice.enums.EnumRate;
import com.merveyilmaz.userservice.enums.EnumStatus;
import com.merveyilmaz.userservice.general.RestResponse;
import com.merveyilmaz.userservice.request.UserReviewSaveRequest;
import com.merveyilmaz.userservice.response.UserReviewDetailDTO;
import com.merveyilmaz.userservice.service.serviceEntity.UserEntityService;
import com.merveyilmaz.userservice.service.serviceEntity.UserReviewEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserReviewControllerContractImplTest {

    @Mock
    private UserReviewEntityService userReviewEntityService;
    @Mock
    private UserEntityService userEntityService;
    @Mock
    private ProductClient productClient;
    @Mock
    private EnumRate rate;
    @Mock
    private EnumStatus status;

    @InjectMocks
    private UserReviewControllerContractImpl userReviewControllerContractImpl;

    @Test
    void shouldSave() {
        //given
        UserReviewSaveRequest request = new UserReviewSaveRequest(1L, 2L, 3L, rate.FIVE, "comment");
        UserReview userReview = new UserReview(5L, 1L, 2L, 4L, rate.TWO, "comment");

        User user = new User();
        user.setId(1L);
        user.setName("merve");
        user.setSurname("yılmaz");

        RestResponse<ProductDTO> productDTOResponse = new RestResponse<>();
        ProductDTO productDTO = new ProductDTO(2L, "araba", 11, LocalDateTime.now(), "desc", 3L, "taşıt", status.ACTIVE);
        productDTOResponse.setData(productDTO);

        UserReviewDetailDTO expectedDTO = new UserReviewDetailDTO(5L, 1L, "merve", "yılmaz",
                "merve yılmaz", 2L, "araba", 3L, "taşıt");


        //when
        when(userReviewEntityService.save(any(UserReview.class))).thenReturn(userReview);
        when(userEntityService.findByIdWithControl(anyLong())).thenReturn(user);
        when(productClient.getProductById(anyLong())).thenReturn(productDTOResponse);

        UserReviewDetailDTO result = userReviewControllerContractImpl.save(request);

        //then
        verify(userReviewEntityService).save(any(UserReview.class));
        verify(userEntityService).findByIdWithControl(anyLong());
        verify(productClient).getProductById(anyLong());

        assertEquals(expectedDTO, result);
    }

    @Test
    void shouldFindAllByUserId() {
        //given
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("merve");
        user.setSurname("yılmaz");

        List<UserReview> userReviews = Collections.singletonList(new UserReview(
                1L, 1L, 4L, 4L, rate.ONE, "comment"
        ));

        RestResponse<ProductDTO> productDTOResponse = new RestResponse<>();
        ProductDTO productDTO = new ProductDTO(4L, "araba", 11, LocalDateTime.now(), "desc", 3L, "taşıt", status.ACTIVE);
        productDTOResponse.setData(productDTO);

        List<UserReviewDetailDTO> expectedDTOs = Collections.singletonList(
                new UserReviewDetailDTO(1L, 1L, "merve", "yılmaz",
                        "merve yılmaz", 4L, "araba", 3L, "taşıt")
        );

        //when
        when(userReviewEntityService.findAllByUserId(anyLong())).thenReturn(userReviews);
        when(userEntityService.findByIdWithControl(anyLong())).thenReturn(user);
        when(productClient.getProductById(anyLong())).thenReturn(productDTOResponse);

        List<UserReviewDetailDTO> result = userReviewControllerContractImpl.findAllByUserId(userId);

        //then
        verify(userReviewEntityService).findAllByUserId(userId);
        verify(userEntityService).findByIdWithControl(anyLong());
        verify(productClient).getProductById(anyLong());

        assertEquals(expectedDTOs, result);
    }


    @Test
    void shouldFindAllByProductId() {
        //given
        Long productId = 4L;
        List<UserReview> userReviews = Collections.singletonList(new UserReview());
        userReviews.get(0).setProductId(productId);
        userReviews.get(0).setUserId(2L);
        userReviews.get(0).setId(1L);

        User user = new User();
        user.setId(2L);
        user.setName("merve");
        user.setSurname("yılmaz");

        RestResponse<ProductDTO> productDTOResponse = new RestResponse<>();
        ProductDTO productDTO = new ProductDTO(4L, "araba", 11, LocalDateTime.now(), "desc", 3L, "taşıt", status.ACTIVE);
        productDTOResponse.setData(productDTO);

        List<UserReviewDetailDTO> expectedDTOs = Collections.singletonList(
                new UserReviewDetailDTO(1L, 2L, "merve", "yılmaz",
                        "merve yılmaz", 4L, "araba", 3L, "taşıt")
        );

        //when
        when(userReviewEntityService.findAllByProductId(anyLong())).thenReturn(userReviews);
        when(userEntityService.findByIdWithControl(anyLong())).thenReturn(user);
        when(productClient.getProductById(anyLong())).thenReturn(productDTOResponse);

        List<UserReviewDetailDTO> result = userReviewControllerContractImpl.findAllByProductId(productId);

        //then
        verify(userReviewEntityService).findAllByProductId(productId);
        verify(userEntityService).findByIdWithControl(anyLong());
        verify(productClient).getProductById(anyLong());

        assertEquals(expectedDTOs, result);
    }

    @Test
    void shouldEditComment() {
        //given
        Long id = 1L;
        String newComment = "New comment";
        UserReview userReview = new UserReview();
        userReview.setId(id);
        userReview.setComment(newComment);
        userReview.setUserId(2L);
        userReview.setProductId(4L);

        User user = new User();
        user.setId(2L);
        user.setName("merve");
        user.setSurname("yılmaz");

        ProductDTO productDTO = new ProductDTO(4L, "araba", 11, LocalDateTime.now(), "desc", 3L, "taşıt", status.ACTIVE);
        RestResponse<ProductDTO> productDTOResponse = new RestResponse<>();
        productDTOResponse.setData(productDTO);

        UserReviewDetailDTO expectedDTO = new UserReviewDetailDTO(1L, 2L, "merve", "yılmaz",
                "merve yılmaz", 4L, "araba", 3L, "taşıt");

        //when
        when(userReviewEntityService.findByIdWithControl(id)).thenReturn(userReview);
        when(userEntityService.findByIdWithControl(anyLong())).thenReturn(user);
        when(productClient.getProductById(anyLong())).thenReturn(productDTOResponse);

        UserReviewDetailDTO result = userReviewControllerContractImpl.editComment(id, newComment);

        //then
        verify(userReviewEntityService).findByIdWithControl(id);
        verify(userReviewEntityService).save(any(UserReview.class));
        verify(userEntityService).findByIdWithControl(anyLong());
        verify(productClient).getProductById(anyLong());

        assertEquals(expectedDTO, result);
    }
}
