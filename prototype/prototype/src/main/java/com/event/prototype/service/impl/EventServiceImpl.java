package com.event.prototype.service.impl;

import com.event.prototype.data.dto.EventDto;
import com.event.prototype.data.dto.EventDtoForList;
import com.event.prototype.data.dto.UserBasicDataDto;
import com.event.prototype.data.entity.Event;
import com.event.prototype.data.entity.Picture;
import com.event.prototype.data.entity.User;
import com.event.prototype.repository.EventRepository;
import com.event.prototype.service.EventService;
import com.event.prototype.service.PictureService;
import com.event.prototype.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final UserService userService;
    private final EventRepository eventRepository;
    private final PictureService pictureService;

    public EventServiceImpl(UserService userService, EventRepository eventRepository, PictureService pictureService) {
        this.userService = userService;
        this.eventRepository = eventRepository;
        this.pictureService = pictureService;
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

        for(Picture p: event.getPictures()){
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

    @Override
    public List<EventDtoForList> findAll() {
        List<Event> events = eventRepository.findAll();
        List<EventDtoForList> dtoEvents = new ArrayList<>();
        for(Event e: events){
            dtoEvents.add(new EventDtoForList(e));
        }
        return dtoEvents;
    }

    @Override
    public void addAvatar(User user, MultipartFile file, Long eventId) throws Exception {
        Event event = eventRepository.findById(eventId).get();
        if(!event.getAuthor().getId().equals(user.getId())){
            throw new Exception();
        }
        Picture picture = pictureService.create(file);
        event.setAvatar(picture);
        event.getPictures().add(picture);
    }

}
