package com.event.prototype.data.dto;

import com.event.prototype.data.entity.Event;
import com.event.prototype.utils.TimeHelper;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString()
@EqualsAndHashCode()
public class EventDtoForList {

    private Long id;

    private String title;

    private String description;

    @JsonFormat(pattern = TimeHelper.LOCAL_DATE_FORMAT)
    private LocalDate start;

    private Long avatarId;

    public EventDtoForList(Event event){
        this.id = event.getId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        if(event.getStart() != null){
            this.start = event.getStart().toLocalDate();
        }
        if(event.getAvatar() != null){
            avatarId = event.getAvatar().getId();
        }
    }
}
