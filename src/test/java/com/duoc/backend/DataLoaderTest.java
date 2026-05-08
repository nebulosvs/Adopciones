package com.duoc.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.duoc.backend.pet.PetRepository;
import com.duoc.backend.user.DataLoader;
import com.duoc.backend.user.UserRepository;

class DataLoaderTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PetRepository petRepository;

    @InjectMocks
    private DataLoader dataLoader;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // CUANDO TODO ESTÁ VACÍO
    @Test
    void shouldLoadInitialDataWhenRepositoriesAreEmpty() throws Exception {

        when(userRepository.count()).thenReturn(0L);
        when(petRepository.count()).thenReturn(0L);

        dataLoader.initDatabase().run();

        // USERS → 1
        verify(userRepository, times(1)).save(any());

        // PETS → 2
        verify(petRepository, times(2)).save(any());
    }

    // CUANDO YA EXISTEN DATOS
    @Test
    void shouldNotLoadDataWhenRepositoriesAreNotEmpty() throws Exception {

        when(userRepository.count()).thenReturn(1L);
        when(petRepository.count()).thenReturn(1L);

        dataLoader.initDatabase().run();

        verify(userRepository, never()).save(any());
        verify(petRepository, never()).save(any());
    }
}
