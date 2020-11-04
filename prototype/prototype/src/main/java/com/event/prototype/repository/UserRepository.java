package com.event.prototype.repository;

import com.event.prototype.authentication.JwtUserDetails;
import com.event.prototype.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String name);


}
