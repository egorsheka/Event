package com.event.prototype.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {


    @Id
    private Long id;
    private String username;
    private String password;
    private String role;
}
