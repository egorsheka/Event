package com.event.prototype.service.impl;

import com.event.prototype.authentication.JwtUserDetails;
import com.event.prototype.data.entity.User;
import com.event.prototype.repository.UserRepository;
import com.event.prototype.service.PictureService;
import com.event.prototype.service.UserService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PictureService pictureService;

    public UserServiceImpl(UserRepository userRepository, PictureService pictureService) {
        this.userRepository = userRepository;
        this.pictureService = pictureService;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addAvatar(User user, MultipartFile file) {
        user.getPhotos().add(pictureService.create(file));
    }

    @Override
    public User getCurrentUser() {
        return userRepository.getOne(getCurrentUserId());
    }

    public Long getCurrentUserId() {
        JwtUserDetails user = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      return user.getId();
    }

}
