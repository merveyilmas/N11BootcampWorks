package com.merveyilmaz.firsthomework.controller;

import com.merveyilmaz.firsthomework.entitiy.User;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping
    public List<User> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return null;
    }

    @GetMapping("/with-username/{username}")
    public User findByUserName(@PathVariable String userName) {
        return null;
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return null;
    }

    @PutMapping("/{debugUserId}")
    public User update(@PathVariable Long debugUserId, @RequestBody User user) {
        return null;
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable Long id) {
        return null;
    }

    @PatchMapping("/{id}/status")
    public User deactivate(@PathVariable Long id, @RequestBody User user) {
        return null;
    }
}
