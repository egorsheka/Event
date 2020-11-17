package com.event.prototype.data.entity;


import com.event.prototype.data.dto.EventDto;
import com.event.prototype.data.enums.EventCategory;
import com.event.prototype.data.enums.EventType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Event extends AbstractAutoGeneratedIdEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id")
    @NonNull
    private User author;

    @Column(length = 500)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private EventCategory category;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private LocalDateTime start;

    private LocalDateTime finish;

    @Column(length = 150)
    private String place;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="events_pictures",
            joinColumns = @JoinColumn( name="picture_id"),
            inverseJoinColumns = @JoinColumn( name="event_id")
    )
    private List<Picture> pictures;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avatar_id")
    private Picture avatar;

    public Event(EventDto dto){
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.category = dto.getCategory();
        this.start = dto.getStart();
        this.finish = dto.getFinish();
        this.place = dto.getPlace();
    }












}
