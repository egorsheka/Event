package com.event.prototype.service;

import com.event.prototype.data.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);


}
