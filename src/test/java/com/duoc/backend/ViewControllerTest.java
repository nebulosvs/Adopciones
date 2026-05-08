package com.duoc.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(ViewController.class)
@AutoConfigureMockMvc(addFilters = false)
class ViewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnLoginView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

    @Test
    void shouldReturnDashboardView() throws Exception {
        mockMvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(view().name("dashboard"));
    }

    @Test
    void shouldReturnPetsView() throws Exception {
        mockMvc.perform(get("/pets"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets"));
}

    @Test
    void shouldReturnAdoptionView() throws Exception {
        mockMvc.perform(get("/adoption"))
                .andExpect(status().isOk())
                .andExpect(view().name("adoption"));
}
}