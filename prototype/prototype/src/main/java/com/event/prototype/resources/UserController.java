package com.event.prototype.resources;

import com.event.prototype.data.dto.UserDto;
import com.event.prototype.data.entity.User;
import com.event.prototype.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return null;
    }

    @GetMapping(value = "user")
    @Transactional
    public ResponseEntity<?> getCurrentUser() {
        User user = userService.getCurrentUser();
        return ResponseEntity.ok(new UserDto(user));
    }
}
