package com.merveyilmaz.userservice.controller;

import com.merveyilmaz.userservice.controller.concract.UserReviewControllerContract;
import com.merveyilmaz.userservice.general.RestResponse;
import com.merveyilmaz.userservice.request.UserReviewSaveRequest;
import com.merveyilmaz.userservice.response.UserReviewDetailDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userReviews")
public class UserReviewController {

    private UserReviewControllerContract userReviewControllerContract;

    public UserReviewController(UserReviewControllerContract userReviewControllerContract) {
        this.userReviewControllerContract = userReviewControllerContract;
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserReviewDetailDTO>> save(@RequestBody UserReviewSaveRequest request) {

        UserReviewDetailDTO userReviewDetailDTO = userReviewControllerContract.save(request);

        return ResponseEntity.ok(RestResponse.of(userReviewDetailDTO));
    }

    @GetMapping("/with-userId/{userId}")
    public ResponseEntity<RestResponse<List<UserReviewDetailDTO>>> findAllByUserId(@PathVariable Long userId) {

        List<UserReviewDetailDTO> userReviewDetailDTOs = userReviewControllerContract.findAllByUserId(userId);
        return ResponseEntity.ok(RestResponse.of(userReviewDetailDTOs));
    }

    @GetMapping("/with-productId/{productId}")
    public ResponseEntity<RestResponse<List<UserReviewDetailDTO>>> findAllByProductId(@PathVariable Long productId) {

        List<UserReviewDetailDTO> userReviewDetailDTOs = userReviewControllerContract.findAllByProductId(productId);
        return ResponseEntity.ok(RestResponse.of(userReviewDetailDTOs));
    }

    @PatchMapping("/{id}/comment")
    public ResponseEntity<RestResponse<UserReviewDetailDTO>> editComment(@PathVariable Long id, @RequestParam String newComment) {

        UserReviewDetailDTO userReviewDetailDTO = userReviewControllerContract.editComment(id, newComment);
        return ResponseEntity.ok(RestResponse.of(userReviewDetailDTO));
    }
}
