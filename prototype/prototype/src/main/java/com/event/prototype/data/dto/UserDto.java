package com.event.prototype.data.dto;

import com.event.prototype.data.entity.Picture;
import com.event.prototype.data.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


@Getter
@Setter
@NoArgsConstructor()
@ToString
@EqualsAndHashCode
public class UserDto {

    public UserDto(User user){
        this.email = user.getEmail();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.about = user.getAbout();
        this.facebook = user.getFacebook();
        this.instagram = user.getInstagram();
        this.telegram = user.getTelegram();
        if(user.getAvatar() != null){
            this.avatarId = user.getAvatar().getId();
        }
        photoIds = new ArrayList<>();
        for(Picture p: user.getPhotos()){
            photoIds.add(p.getId());
        }
    }

    private String email;
    @JsonIgnore(value = true)
    private String password;

    private String name;
    private String surname;

    private String about;
    private String facebook;
    private String instagram;
    private String telegram;
    private Long avatarId;
    private List<Long> photoIds;

}


