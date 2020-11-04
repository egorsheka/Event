package com.event.prototype.authentication;

import com.event.prototype.entity.User;
import com.event.prototype.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();


  public JwtUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


    Optional<User> user = userRepository.findByEmail(username);


    if (user.isEmpty()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return new JwtUserDetails(user.get());
  }

}


