package com.event.prototype.resources;

import com.event.prototype.data.entity.Picture;
import com.event.prototype.data.entity.User;
import com.event.prototype.data.enums.PictureSize;
import com.event.prototype.service.PictureService;
import com.event.prototype.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PictureController {


    private final UserService userService;
    private final PictureService pictureService;

    public PictureController(UserService userService, PictureService pictureService) {
        this.userService = userService;
        this.pictureService = pictureService;
    }

    @GetMapping("picture/category/{id}")
    @Transactional
    public ResponseEntity getCategoryPictureById(@PathVariable Long id){
     return null;
    }

    @GetMapping("event/category/{id}")
    @Transactional
    public ResponseEntity getEventPictureById(@PathVariable Long id){
        return null;
    }


    @PostMapping("user/photo")
    @Transactional
    public void assignAvatar(@RequestParam @NotNull MultipartFile file) {
        User user = userService.getCurrentUser();
        userService.addAvatar(user, file);
    }

    @GetMapping("user/photo/{id}")
    @Transactional
    public ResponseEntity getUserPhotoById(@PathVariable Long id,
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
