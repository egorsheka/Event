package com.event.prototype.resources;

import com.event.prototype.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/user")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userService.findById(41l));
    }


}
