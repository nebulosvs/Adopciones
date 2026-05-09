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

                Pet p3 = new Pet();
                p3.setName("Luna");
                p3.setType("Perro");
                p3.setAge(1);
                p3.setDescription("Juguetona y cariñosa");
                p3.setAvailable(true);

                Pet p4 = new Pet();
                p4.setName("Tom");
                p4.setType("Gato");
                p4.setAge(4);
                p4.setDescription("Le gusta dormir");
                p4.setAvailable(true);

                Pet p5 = new Pet();
                p5.setName("Rocky");
                p5.setType("Perro");
                p5.setAge(5);
                p5.setDescription("Protector y tranquilo");
                p5.setAvailable(false);


                petRepository.save(p1);
                petRepository.save(p2);
                petRepository.save(p3);
                petRepository.save(p4);
                petRepository.save(p5);
            }

            System.out.println("Datos iniciales cargados.");
        };
    }
}