package com.bondarenko.int20h2021.service;

import com.bondarenko.int20h2021.domain.entity.User;
import com.bondarenko.int20h2021.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccessService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String signIn(String email, String rawPassword) {
        Optional<User> userOptional = userRepository.findById(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (email.equals(user.getEmail()) && passwordEncoder.matches(rawPassword, user.getPassword())) {
                return email + '$' + System.currentTimeMillis();
            }
        }

        return "";
    }

    public String signUp(String email, String rawPassword, String name, String surname) {
        Optional<User> userOptional = userRepository.findById(email);

        if (!userOptional.isPresent()) {
            String password = passwordEncoder.encode(rawPassword);
            User user = new User(email, password, name, surname);
            userRepository.save(user);
            return email + '$' + System.currentTimeMillis();
        }

        return "";
    }
}
