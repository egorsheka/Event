package com.event.prototype.service;

import com.event.prototype.data.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    void addAvatar(User user, MultipartFile file);

    User getCurrentUser();
}
