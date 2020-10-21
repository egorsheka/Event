package com.event.prototype.dto;


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
public class User {

    private String name;
    private String password;

}
