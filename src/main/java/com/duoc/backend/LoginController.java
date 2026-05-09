package com.duoc.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.backend.user.MyUserDetailsService;
import com.duoc.backend.user.User;

@RestController
public class LoginController {

    @Autowired
    private JWTAuthenticationConfig jwtAuthenticationConfig;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {

        try {

            User user = (User) userDetailsService
                    .loadUserByUsername(loginRequest.getUsername());

            // VALIDAR PASSWORD
            if (!user.getPassword().equals(loginRequest.getPassword())) {

                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Invalid password");
            }

            String token =
                    jwtAuthenticationConfig.getJWTToken(user.getUsername());

            return ResponseEntity.ok(token);

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid login");
        }
    }
}