package com.event.prototype.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController()
public class EventController {


    @GetMapping("events/search")
    @Transactional
    public ResponseEntity getEventsBySearchFilters() {
        return null;
    }

    @GetMapping("events")
    @Transactional
    public ResponseEntity getEventsWithStatus(@PathVariable Long id) {
        return null;
    }


    @GetMapping("event/{id}")
    @Transactional
    public ResponseEntity getEvent(@PathVariable Long id) {
        return null;
    }

    @PostMapping("event/{id}")
    @Transactional
    public ResponseEntity createEvent(@PathVariable Long id) {
        return null;
    }

    @PutMapping("event/{id}")
    @Transactional
    public ResponseEntity editEvent(@PathVariable Long id) {
        return null;
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
