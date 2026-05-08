package com.duoc.backend;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.duoc.backend.pet.Pet;
import com.duoc.backend.pet.PetController;
import com.duoc.backend.pet.PetService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@WebMvcTest(PetController.class)
@AutoConfigureMockMvc(addFilters = false)
class PetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetService petService;

    @Test
    void shouldGetAllPets() throws Exception {
        when(petService.getAllPets()).thenReturn(List.of(new Pet()));

        mockMvc.perform(get("/pets"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetPetById() throws Exception {
        when(petService.getPetById(1L)).thenReturn(new Pet());

        mockMvc.perform(get("/pets/1"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreatePet() throws Exception {
        Pet pet = new Pet();

        when(petService.savePet(any())).thenReturn(pet);

        mockMvc.perform(post("/pets")
                .contentType("application/json")
                .content("{}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeletePet() throws Exception {

        mockMvc.perform(delete("/pets/1"))
                .andExpect(status().isOk());

        verify(petService, times(1)).deletePet(1L);
    }
}
    

