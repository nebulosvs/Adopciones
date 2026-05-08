package com.duoc.backend.adoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {

    @Autowired
    private AdoptionRepository adoptionRepository;

    public AdoptionRequest saveRequest(AdoptionRequest request) {
        return adoptionRepository.save(request);
    }
}