package com.duoc.backend;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.duoc.backend.pet.Pet;
import com.duoc.backend.pet.PetRepository;
import com.duoc.backend.pet.PetService;

class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private PetService petService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllPets() {
        when(petRepository.findAll()).thenReturn(List.of(new Pet()));

        List<Pet> pets = petService.getAllPets();

        assertEquals(1, pets.size());
    }

    @Test
    void shouldGetPetById() {
        Pet pet = new Pet();
        pet.setId(1L);

        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));

        Pet result = petService.getPetById(1L);

        assertEquals(1L, result.getId());
    }

    @Test
    void shouldSavePet() {
        Pet pet = new Pet();

        when(petRepository.save(pet)).thenReturn(pet);

        Pet result = petService.savePet(pet);

        assertEquals(pet, result);
    }

    @Test
    void shouldDeletePet() {
        Long id = 1L;

        petService.deletePet(id);

        verify(petRepository, times(1)).deleteById(id);
    }
}