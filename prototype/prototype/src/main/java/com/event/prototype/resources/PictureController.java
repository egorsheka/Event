package com.event.prototype.resources;

import com.event.prototype.data.entity.User;
import com.event.prototype.exceptions.ResourceNotFoundException;
import com.event.prototype.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PictureController {


    private final UserService userService;

    public PictureController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user/{id}/pic")
    @Transactional
    public void assignAvatar(@PathVariable Long id, @RequestParam @NotNull MultipartFile file) {
        User user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException(User.class, id, "id"));

    }





}
