package com.event.prototype.data.dto;

import com.event.prototype.data.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


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
    }

    private String email;
    private String password;

    private String name;
    private String surname;

    private String about;
    private String facebook;
    private String instagram;
    private String telegram;

}


