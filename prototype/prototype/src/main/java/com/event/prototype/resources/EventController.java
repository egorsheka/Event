package com.event.prototype.resources;

import com.event.prototype.data.dto.EventDto;
import com.event.prototype.data.dto.IdDto;
import com.event.prototype.data.entity.User;
import com.event.prototype.service.EventService;
import com.event.prototype.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController()
public class EventController {

    private final UserService userService;
    private final EventService eventService;

    public EventController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("events")
    @Transactional
    public ResponseEntity getEventsWithStatus(@PathVariable Long id) {
        return null;
    }

    @GetMapping("event/{id}")
    @Transactional
    public ResponseEntity getEvent(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.read(id));
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

    @GetMapping("event/{id}/go")
    @Transactional
    public ResponseEntity go(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("event/{id}/go")
    @Transactional
    public ResponseEntity leave(@PathVariable Long id) {
        return null;
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
