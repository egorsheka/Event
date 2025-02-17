package com.event.prototype.resources;

import com.event.prototype.data.dto.EventDto;
import com.event.prototype.data.dto.EventDtoForList;
import com.event.prototype.data.dto.IdDto;
import com.event.prototype.data.entity.User;
import com.event.prototype.service.EventService;
import com.event.prototype.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController()
public class EventController {

    private final UserService userService;
    private final EventService eventService;

    public EventController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("event/{id}")
    @Transactional
    public ResponseEntity getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.read(id));
    }

    @GetMapping("events")
    @Transactional
    public ResponseEntity findAll() {
        List<EventDtoForList> list = eventService.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("event")
    @Transactional
    public ResponseEntity createEvent(@RequestBody EventDto event) {
        return ResponseEntity.ok(new IdDto(eventService.create(event).getId()));
    }

    @PutMapping("event/{id}")
    @Transactional
    public ResponseEntity editEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.read(id));
    }

    @DeleteMapping("event/{id}")
    @Transactional
    public ResponseEntity deleteEvent(@PathVariable Long id) {
        return null;
    }

    @PostMapping("event/{id}/go")
    @Transactional
    public ResponseEntity go(@PathVariable Long id) {
        User user = userService.getCurrentUser();
        eventService.goEvent(id, user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("event/{id}/leave")
    @Transactional
    public ResponseEntity leave(@PathVariable Long id) {
        User user = userService.getCurrentUser();
        eventService.leaveEvent(id, user);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PostMapping("event/{eventId}/participation/{userId}/approve")
    @Transactional
    public ResponseEntity approveUser(@PathVariable Long eventId, @PathVariable Long userId) {
        return null;
    }

    @PostMapping("event/{eventId}/participation/{userId}/ignore")
    @Transactional
    public ResponseEntity ignoreUser(@PathVariable Long eventId, @PathVariable Long userId) {
        return null;
    }

}
