package com.duoc.backend.adoption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adoption")
public class AdoptionController {

    @Autowired
    private AdoptionService adoptionService;

    @PostMapping
    public AdoptionRequest createRequest(@RequestBody AdoptionRequest request) {
        return adoptionService.saveRequest(request);
    }
}