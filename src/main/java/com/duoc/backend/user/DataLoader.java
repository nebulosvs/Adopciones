package com.duoc.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.duoc.backend.care.Care;
import com.duoc.backend.care.CareRepository;
import com.duoc.backend.medication.Medication;
import com.duoc.backend.medication.MedicationRepository;

@Configuration
public class DataLoader {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CareRepository careRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {

            // USERS
            if(userRepository.count() == 0){

                User u1 = new User();
                u1.setUsername("admin");
                u1.setPassword("1234");
                u1.setEmail("admin@duoc.cl");

                User u2 = new User();
                u2.setUsername("vet");
                u2.setPassword("1234");
                u2.setEmail("vet@duoc.cl");

                User u3 = new User();
                u3.setUsername("user");
                u3.setPassword("1234");
                u3.setEmail("user@duoc.cl");

                userRepository.save(u1);
                userRepository.save(u2);
                userRepository.save(u3);
            }

            // CARES
            if(careRepository.count() == 0){

                Care c1 = new Care();
                c1.setName("Consulta General");
                c1.setCost(15000);

                Care c2 = new Care();
                c2.setName("Vacunacion");
                c2.setCost(20000);

                Care c3 = new Care();
                c3.setName("Cirugia Menor");
                c3.setCost(80000);

                careRepository.save(c1);
                careRepository.save(c2);
                careRepository.save(c3);
            }

            // MEDICATIONS
            if(medicationRepository.count() == 0){

                Medication m1 = new Medication();
                m1.setName("Antibiotico");
                m1.setCost(12000.0);

                Medication m2 = new Medication();
                m2.setName("Antiinflamatorio");
                m2.setCost(9000.0);

                Medication m3 = new Medication();
                m3.setName("Vitaminas");
                m3.setCost(5000.0);

                medicationRepository.save(m1);
                medicationRepository.save(m2);
                medicationRepository.save(m3);
            }

            System.out.println("Datos iniciales cargados.");

        };
    }
}
