package com.duoc.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.duoc.backend.adoption.AdoptionRepository;
import com.duoc.backend.adoption.AdoptionRequest;
import com.duoc.backend.adoption.AdoptionService;

class AdoptionServiceTest {

    @Mock
    private AdoptionRepository adoptionRepository;

    @InjectMocks
    private AdoptionService adoptionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveRequest() {
        AdoptionRequest request = new AdoptionRequest();

        when(adoptionRepository.save(request)).thenReturn(request);

        AdoptionRequest result = adoptionService.saveRequest(request);

        assertEquals(request, result);
    }

    @Test
    void shouldCallRepositorySave() {
        AdoptionRequest req = new AdoptionRequest();

        adoptionService.saveRequest(req);

        verify(adoptionRepository, times(1)).save(req);
    }
}