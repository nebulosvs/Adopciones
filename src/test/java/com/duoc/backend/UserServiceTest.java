package com.duoc.backend;

import com.duoc.backend.user.MyUserDetailsService;
import com.duoc.backend.user.User;
import com.duoc.backend.user.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MyUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private MyUserDetailsService userDetailsService;

    @Test
    void shouldLoadUserByUsername() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("1234");

        when(userRepository.findByUsername("admin")).thenReturn(user);

        UserDetails result = userDetailsService.loadUserByUsername("admin");

        assertNotNull(result);
        assertEquals("admin", result.getUsername());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {
        when(userRepository.findByUsername("notfound")).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("notfound");
        });
    }

    @Test
    void shouldCreatePasswordEncoder() {
        PasswordEncoder encoder = userDetailsService.passwordEncoder();

        assertNotNull(encoder);
    }
}