package com.duoc.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.duoc.backend.pet.Pet;
import com.duoc.backend.pet.PetRepository;

@Configuration
public class DataLoader {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PetRepository petRepository;

    @Bean
    public
    CommandLineRunner initDatabase() {
        return args -> {

            // USERS
            if (userRepository.count() == 0) {

                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword("1234");
                admin.setEmail("admin@duoc.cl");

                userRepository.save(admin);
            }

            // PETS
            if (petRepository.count() == 0) {

                Pet p1 = new Pet();
                p1.setName("Firulais");
                p1.setType("Perro");
                p1.setAge(3);
                p1.setDescription("Muy amigable");
                p1.setAvailable(true);

                Pet p2 = new Pet();
                p2.setName("Mishi");
                p2.setType("Gato");
                p2.setAge(2);
                p2.setDescription("Tranquilo");
                p2.setAvailable(true);

                petRepository.save(p1);
                petRepository.save(p2);
            }

            System.out.println("Datos iniciales cargados.");
        };
    }
}