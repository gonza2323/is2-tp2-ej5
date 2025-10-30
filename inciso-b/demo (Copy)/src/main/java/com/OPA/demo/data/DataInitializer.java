package com.OPA.demo.data;

import com.OPA.demo.Enums.ERole;
import com.OPA.demo.entities.UserEntity;
import com.OPA.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (!userRepository.existsByUsername("admin")) {
            UserEntity adminUser = UserEntity.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .email("admin@example.com")
                    .rol(ERole.ADMIN)
                    .alta(true)
                    .build();

            userRepository.save(adminUser);
        }
    }
}