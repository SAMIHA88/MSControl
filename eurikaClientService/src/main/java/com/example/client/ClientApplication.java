package com.example.client;

import com.example.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner initializeH2Database(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new com.example.client.entities.Client(null, "Samiha", 22));
            clientRepository.save(new com.example.client.entities.Client(null, "Kamal", 47));
            clientRepository.save(new com.example.client.entities.Client(null, "Nadia", 47));
            clientRepository.save(new com.example.client.entities.Client(null, "Nihal", 15));
        };
    }
}
