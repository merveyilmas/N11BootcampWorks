package com.merveyilmaz.firsthomework.controller;

import com.merveyilmaz.firsthomework.entitiy.UserCoupon;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userCoupons")
public class UserCouponController {

    @GetMapping("/with-userId/{id}")
    public List<UserCoupon> findAllByUserId(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/{id}")
    public UserCoupon findById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public UserCoupon save(@RequestBody UserCoupon userCoupon) {
        return null;
    }

    @DeleteMapping("/{id}")
    public UserCoupon delete(@PathVariable Long id) {
        return null;
    }

}
