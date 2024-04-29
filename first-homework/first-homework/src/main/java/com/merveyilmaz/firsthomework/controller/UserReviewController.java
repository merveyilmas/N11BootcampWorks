package com.merveyilmaz.firsthomework.controller;

import com.merveyilmaz.firsthomework.entitiy.UserReview;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userReviews")
public class UserReviewController {

    @PostMapping
    public UserReview save(@RequestBody UserReview userReview) {
        return null;
    }

    @GetMapping("/with-userId/{id}")
    public List<UserReview> findAllByUserId(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/with-productId/{id}")
    public List<UserReview> findAllByProductId(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/{id}")
    public UserReview findById(@PathVariable Long id) {
        return null;
    }

    @PatchMapping("/{id}/comment")
    public UserReview editComment(@PathVariable Long id, @RequestBody UserReview UserReview) {
        return null;
    }
}
