package com.event.prototype.resources;

import com.event.prototype.data.entity.Picture;
import com.event.prototype.data.entity.User;
import com.event.prototype.data.enums.PictureSize;
import com.event.prototype.exceptions.ResourceNotFoundException;
import com.event.prototype.service.PictureService;
import com.event.prototype.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PictureController {


    private final UserService userService;
    private final PictureService pictureService;

    public PictureController(UserService userService, PictureService pictureService) {
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @PostMapping("user/{id}/photo")
    @Transactional
    public void assignAvatar(@PathVariable Long id, @RequestParam @NotNull MultipartFile file) {
        User user = userService.findById(id).orElseThrow(() -> new ResourceNotFoundException(User.class, id, "id"));
        userService.addAvatar(user, file);
    }

    @GetMapping("user/photo/{id}")
    @Transactional
    public ResponseEntity getPictureById(@PathVariable Long id,
                                         @RequestParam(required = false) PictureSize size,
                                         @RequestParam(required = false) String format) {

        Picture picture = pictureService.findById(id);
        byte[] picData = pictureService.getPicBySize(picture, size);

        if (format == null) {
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(picture.getMimeType())).body(picData);
        } else {
            return ResponseEntity.ok(pictureService.getPicInBase64(picData, picture.getMimeType()));
        }
    }
}
