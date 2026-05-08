package com.duoc.backend.adoption;

import com.duoc.backend.pet.Pet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AdoptionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;
    private String email;
    private String message;

    @ManyToOne
    private Pet pet;

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Pet getPet() {

        if (pet == null) {
            return null;
        }

        Pet copy = new Pet();

        copy.setId(pet.getId());
        copy.setName(pet.getName());

        return copy;
    }

    public void setPet(Pet pet) {

        if (pet == null) {
            this.pet = null;
            return;
        }

        Pet copy = new Pet();

        copy.setId(pet.getId());
        copy.setName(pet.getName());

        this.pet = copy;
    }

}