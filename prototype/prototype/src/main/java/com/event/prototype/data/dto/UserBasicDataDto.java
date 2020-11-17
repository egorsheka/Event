package com.event.prototype.data.dto;

import com.event.prototype.data.entity.Picture;
import com.event.prototype.data.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Basic data about user.
 */
@Data
@NoArgsConstructor
public class UserBasicDataDto {

    private Long id;
    private String name;
    private String surname;
    private Long avatarId;

    public UserBasicDataDto(User user) {
        this(user.getId(), user.getName(), user.getSurname(), user.getAvatar());
    }

    public UserBasicDataDto(Long id, String name, String surname, Picture avatar) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        if(avatar != null){
            this.avatarId = avatar.getId();
        }
    }


}