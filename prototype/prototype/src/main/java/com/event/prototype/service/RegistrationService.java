package com.event.prototype.service;

import com.event.prototype.authentication.resource.JwtTokenResponse;
import com.event.prototype.data.entity.User;

public interface RegistrationService {
    JwtTokenResponse register(User user);
}
