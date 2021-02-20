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

    public String signIn(String login, String rawPassword) {
        Optional<User> userOptional = userRepository.findById(login);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (login.equals(user.getLogin()) && passwordEncoder.matches(rawPassword, user.getPassword())) {
                return login + '$' + System.currentTimeMillis();
            }
        }

        return "";
    }

    public boolean signUp(String login, String rawPassword) {
        Optional<User> userOptional = userRepository.findById(login);

        if (!userOptional.isPresent()) {
            String password = passwordEncoder.encode(rawPassword);
            User user = new User(login, password);
            userRepository.save(user);
            return true;
        }

        return false;
    }
}
