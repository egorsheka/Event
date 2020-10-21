package com.event.prototype.authentication.resource;


import com.event.prototype.dto.UserDto;
import com.event.prototype.entity.User;
import com.event.prototype.service.AuthenticationService;
import com.event.prototype.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationController {

    private final RegistrationService registrationService;

    private final AuthenticationService authenticationService;

    public JwtAuthenticationController(RegistrationService registrationService, AuthenticationService authenticationService) {
        this.registrationService = registrationService;
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "${jwt.get.token.uri}")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticateUser(authenticationRequest));
    }

    @PostMapping(value = "/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        return ResponseEntity.ok(registrationService.register(user));
    }


//  @Value("${jwt.http.request.header}")
//  private String tokenHeader;
//  @GetMapping(value = "${jwt.refresh.token.uri}")
//  public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
//    String authToken = request.getHeader(tokenHeader);
//    final String token = authToken.substring(7);
//    String username = jwtTokenUtil.getUsernameFromToken(token);
//    JwtUserDetails user = (JwtUserDetails) jwtUserDetailsService.loadUserByUsername(username);
//
//    if (jwtTokenUtil.canTokenBeRefreshed(token)) {
//      String refreshedToken = jwtTokenUtil.refreshToken(token);
//      return ResponseEntity.ok(new JwtTokenResponse(refreshedToken));
//    } else {
//      return ResponseEntity.badRequest().body(null);
//    }
//  }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }


}

