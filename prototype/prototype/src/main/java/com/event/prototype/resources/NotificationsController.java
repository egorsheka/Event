package com.event.prototype.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationsController {

    @GetMapping("notifications")
    public ResponseEntity getNotification(){
        return null;
    }




}
