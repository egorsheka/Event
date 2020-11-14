package com.event.prototype.repository;

import com.event.prototype.data.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long > {
}
