package com.duoc.backend;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.duoc.backend.adoption.AdoptionController;
import com.duoc.backend.adoption.AdoptionRequest;
import com.duoc.backend.adoption.AdoptionService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdoptionController.class)
@AutoConfigureMockMvc(addFilters = false)
class AdoptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdoptionService adoptionService;

    @Test
    void shouldCreateAdoptionRequest() throws Exception {

        AdoptionRequest req = new AdoptionRequest();

        when(adoptionService.saveRequest(any())).thenReturn(req);

        mockMvc.perform(post("/adoption")
                .contentType("application/json")
                .content("{}"))
                .andExpect(status().isOk());
    }
}

