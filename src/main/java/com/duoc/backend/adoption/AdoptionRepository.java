package com.duoc.backend.adoption;

import org.springframework.data.repository.CrudRepository;

public interface AdoptionRepository extends CrudRepository<AdoptionRequest, Long> {
}
