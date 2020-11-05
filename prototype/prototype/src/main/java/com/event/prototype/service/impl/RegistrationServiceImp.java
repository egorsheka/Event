package com.event.prototype.service.impl;

import com.event.prototype.authentication.JwtTokenUtil;
import com.event.prototype.authentication.resource.AuthenticationException;
import com.event.prototype.authentication.resource.JwtTokenResponse;
import com.event.prototype.data.entity.User;
import com.event.prototype.data.enums.UserRole;
import com.event.prototype.repository.UserRepository;
import com.event.prototype.service.RegistrationService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImp implements RegistrationService {

    private final UserRepository userRepository;
    private final UserDetailsService jwtUserDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public RegistrationServiceImp(UserRepository userRepository, UserDetailsService jwtUserDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public JwtTokenResponse register(User user) {
        user.setRole(UserRole.USER);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new AuthenticationException("USER_ALREADY_EXISTS", e);
        }
        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(user.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new JwtTokenResponse(token);
    }
}
