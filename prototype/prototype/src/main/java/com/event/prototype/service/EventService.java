package com.event.prototype.service;

import com.event.prototype.data.dto.EventDto;
import com.event.prototype.data.dto.EventDtoForList;
import com.event.prototype.data.entity.Event;
import com.event.prototype.data.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface EventService {

    EventDto create(EventDto event);
    EventDto read(Long id);
    EventDto update(EventDto event);
    EventDto delete(Long id);
    List<EventDtoForList> findAll();

    Event findById(Long id);

    void goEvent(Long id, User user);
    void leaveEvent(Long id, User user);

    void addAvatar(User user, MultipartFile file, Long eventId) throws Exception;
}
