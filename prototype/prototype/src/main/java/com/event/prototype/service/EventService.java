package com.event.prototype.service;

import com.event.prototype.data.dto.EventDto;
import com.event.prototype.data.entity.Event;

public interface EventService {

    EventDto create(EventDto event);
    EventDto read(Long id);
    EventDto update(EventDto event);
    EventDto delete(Long id);
}
