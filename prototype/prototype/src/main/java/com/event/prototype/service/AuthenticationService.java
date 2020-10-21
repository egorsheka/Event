package com.event.prototype.service;

import com.event.prototype.authentication.resource.JwtTokenRequest;
import com.event.prototype.authentication.resource.JwtTokenResponse;

public interface AuthenticationService {
    JwtTokenResponse authenticateUser(JwtTokenRequest request);
}
