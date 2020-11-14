package com.event.prototype.service.impl;

import com.event.prototype.data.dto.EventDto;
import com.event.prototype.data.dto.UserBasicDataDto;
import com.event.prototype.data.entity.Event;
import com.event.prototype.data.entity.Picture;
import com.event.prototype.repository.EventRepository;
import com.event.prototype.service.EventService;
import com.event.prototype.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private final UserService userService;
    private final EventRepository eventRepository;

    public EventServiceImpl(UserService userService, EventRepository eventRepository) {
        this.userService = userService;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDto create(EventDto dto) {
        Event event = new Event(dto);
        event.setAuthor(userService.getCurrentUser());
        Event newEvent = eventRepository.save(event);

        return new EventDto(newEvent.getId());
    }

    @Override
    public EventDto read(Long id) {
        Event event = eventRepository.getOne(id);
        EventDto eventDto = new EventDto(event);

        for(Picture p: event.getPicture()){
            eventDto.getPictureIds().add(p.getId());
        }
        UserBasicDataDto userDto = new UserBasicDataDto(userService.getCurrentUser());
        eventDto.setAuthor(userDto);

        return eventDto;
    }

    @Override
    public EventDto update(EventDto event) {
        return null;
    }

    @Override
    public EventDto delete(Long id) {
        return null;
    }

}
