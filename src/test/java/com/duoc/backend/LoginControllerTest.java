package com.duoc.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.duoc.backend.user.MyUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;



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

    // LOGIN OK
    @Test
    void shouldLoginSuccessfully() throws Exception {

        com.duoc.backend.user.User loginRequest = new com.duoc.backend.user.User();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("1234");

        com.duoc.backend.user.User userDetails = new com.duoc.backend.user.User();
        userDetails.setUsername("admin");
        userDetails.setPassword("1234");

        when(userDetailsService.loadUserByUsername("admin"))
                .thenReturn(userDetails);

        when(jwtAuthenticationConfig.getJWTToken("admin"))
                .thenReturn("Bearer fake-token");

        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
                .andExpect(status().isOk())
                .andExpect(content().string("Bearer fake-token"));
    }

    // LOGIN FAIL (password incorrecta)
    @Test
    void shouldFailLoginWhenPasswordIsIncorrect() throws Exception {

        com.duoc.backend.user.User loginRequest = new com.duoc.backend.user.User();
        loginRequest.setUsername("admin");
        loginRequest.setPassword("wrong");

        com.duoc.backend.user.User userDetails = new com.duoc.backend.user.User();
        userDetails.setUsername("admin");
        userDetails.setPassword("1234"); // password real

        when(userDetailsService.loadUserByUsername("admin"))
                .thenReturn(userDetails);

        Exception exception = assertThrows(ServletException.class, () -> {
        mockMvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginRequest)))
                .andReturn();
       });

        //  VALIDAMOS LA CAUSA REAL
        assertTrue(exception.getCause() instanceof RuntimeException);
        assertEquals("Invalid login", exception.getCause().getMessage());
  }
}