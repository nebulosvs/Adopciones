package com.duoc.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.duoc.backend.adoption.AdoptionRequest;
import com.duoc.backend.pet.Pet;

class AdoptionRequestTest {

    @Test
    void shouldSetAndGetAllFields() {

        AdoptionRequest request = new AdoptionRequest();
        Pet pet = new Pet();

        request.setId(1L);
        request.setApplicantName("Juan");
        request.setEmail("juan@test.com");
        request.setMessage("Quiero adoptar");
        request.setPet(pet);

        assertEquals(1L, request.getId());
        assertEquals("Juan", request.getApplicantName());
        assertEquals("juan@test.com", request.getEmail());
        assertEquals("Quiero adoptar", request.getMessage());
        assertEquals(pet, request.getPet());
    }
}