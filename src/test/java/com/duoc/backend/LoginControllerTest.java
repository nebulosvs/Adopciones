package com.duoc.backend;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.duoc.backend.user.MyUserDetailsService;
import com.duoc.backend.user.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(LoginController.class)
@AutoConfigureMockMvc(addFilters = false)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyUserDetailsService userDetailsService;

    @MockBean
    private JWTAuthenticationConfig jwtAuthenticationConfig;

    @Autowired
    private ObjectMapper objectMapper;

    // =========================
    // LOGIN OK
    // =========================

    @Test
    void shouldLoginSuccessfully() throws Exception {

        User loginRequest = new User();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("1234");

        User userDetails = new User();
        userDetails.setUsername("admin");
        userDetails.setPassword("1234");

        when(userDetailsService.loadUserByUsername("admin"))
                .thenReturn(userDetails);

        when(jwtAuthenticationConfig.getJWTToken("admin"))
                .thenReturn("Bearer fake-token");

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Bearer fake-token"));
    }

    // =========================
    // LOGIN FAIL
    // =========================

    @Test
    void shouldFailLoginWhenPasswordIsIncorrect() throws Exception {

        User loginRequest = new User();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("wrong");

        User userDetails = new User();
        userDetails.setUsername("admin");
        userDetails.setPassword("1234");

        when(userDetailsService.loadUserByUsername("admin"))
                .thenReturn(userDetails);

        mockMvc.perform(post("/api/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isUnauthorized());
    }
}