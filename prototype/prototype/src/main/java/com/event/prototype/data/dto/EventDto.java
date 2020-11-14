package com.event.prototype.data.dto;

import com.event.prototype.data.entity.Event;
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

    private String category;

    private LocalDateTime start;

    private LocalDateTime finish;

    private String eventType;

    private String place;

    private List<Long> pictureIds;


    //написать Dto на User в этом классе

    public EventDto(Long id){
        this.id = id;
    }
    public EventDto(Event event){
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.category = event.getCategory();
        this.start = event.getStart();
        this.finish = event.getFinish();
        this.place = event.getPlace();
        pictureIds = new ArrayList<>();
    }

}
