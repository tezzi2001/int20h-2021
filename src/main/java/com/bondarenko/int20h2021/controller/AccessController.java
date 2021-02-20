package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.entity.User;
import com.bondarenko.int20h2021.domain.json.UserWithSessionId;
import com.bondarenko.int20h2021.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class AccessController {
    private final AccessService accessService;

    @PostMapping("/authentication")
    public UserWithSessionId signIn(@RequestBody User user, HttpServletResponse response) {
        String sessionId = accessService.signIn(user);

        if (sessionId.equals("")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        user.setPassword("");
        return new UserWithSessionId(user, sessionId);
    }

    @PostMapping("/registration")
    public UserWithSessionId signUp(@RequestBody User user, HttpServletResponse response) {
        String sessionId = accessService.signUp(user.getEmail(), user.getPassword(), user.getName(), user.getSurname());

        if (sessionId.equals("")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        user.setPassword("");
        return new UserWithSessionId(user, sessionId);
    }

    @GetMapping("/fetchUser")
    public User fetchUser(HttpServletRequest request) {
        String sessionId = request.getHeader("Authorization");
        String bearer = sessionId.split("Bearer ")[1];
        String s = bearer.split("%")[0];
        return accessService.fetchUser(s);
    }
}
