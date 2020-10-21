package com.event.prototype.entity;

import com.event.prototype.dto.UserDto;
import lombok.*;

import javax.persistence.*;

@Entity(name = "users")

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {


    @Id
    @GeneratedValue
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;
    private String role;

    public User(UserDto dto){
        username = dto.getUsername();
        password = dto.getPassword();
    }

}
