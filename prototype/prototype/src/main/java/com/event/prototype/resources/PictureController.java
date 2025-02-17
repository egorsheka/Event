package com.event.prototype.resources;

import com.event.prototype.data.entity.Picture;
import com.event.prototype.data.entity.User;
import com.event.prototype.data.enums.PictureSize;
import com.event.prototype.service.EventService;
import com.event.prototype.service.PictureService;
import com.event.prototype.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PictureController {

    private final UserService userService;
    private final PictureService pictureService;
    private final EventService eventService;

    public PictureController(UserService userService, PictureService pictureService, EventService eventService) {
        this.userService = userService;
        this.pictureService = pictureService;
        this.eventService = eventService;
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
    public void assignUserAvatar(@RequestParam @NotNull MultipartFile file) {
        User user = userService.getCurrentUser();
        userService.addAvatar(user, file);
    }

    @PostMapping("event/{id}/picture")
    @Transactional
    public void assignEventAvatar(@PathVariable Long id, @RequestParam @NotNull MultipartFile file) throws Exception {
        User user = userService.getCurrentUser();
        eventService.addAvatar(user, file, id);
    }

    @GetMapping("picture/{id}")
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
