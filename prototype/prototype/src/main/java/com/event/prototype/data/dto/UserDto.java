package com.event.prototype.data.dto;

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

    private String email;
    private String password;

    private String name;
    private String surname;

    private String about;
    private String facebook;
    private String instagram;
    private String telegram;

}


