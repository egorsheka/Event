package com.event.prototype.data.dto;

import com.event.prototype.data.entity.Event;
import com.event.prototype.data.enums.EventCategory;
import com.event.prototype.data.enums.EventType;
import com.event.prototype.utils.TimeHelper;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString()
@EqualsAndHashCode()
public class EventDto {

    private Long id;

    private UserBasicDataDto author;

    private String title;

    private String description;

    private EventCategory category;

    @JsonFormat(pattern = TimeHelper.DATE_TIME_FORMAT)
    private LocalDateTime start;

    @JsonFormat(pattern = TimeHelper.DATE_TIME_FORMAT)
    private LocalDateTime finish;

    private EventType eventType;

    private String place;

    private List<Long> pictureIds;

    public EventDto(Long id){
        this.id = id;
    }

    public EventDto(Event event){
        this.id = event.getId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.category = event.getCategory();
        this.start = event.getStart();
        this.finish = event.getFinish();
        this.place = event.getPlace();
        pictureIds = new ArrayList<>();
    }

}
