package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.entity.User;
import com.bondarenko.int20h2021.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class AccessController {
    private final AccessService accessService;

    @PostMapping("/authentication")
    public User signIn(@RequestBody User user, HttpServletResponse response) {
        String sessionId = accessService.signIn(user);

        if (sessionId.equals("")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        response.setHeader("Set-Cookie", "sessionId=" + sessionId + "; SameSite=none; Secure");

        user.setPassword("");
        return user;
    }

    @PostMapping("/registration")
    public User signUp(@RequestBody User user, HttpServletResponse response) {
        String sessionId = accessService.signUp(user.getEmail(), user.getPassword(), user.getName(), user.getSurname());

        if (sessionId.equals("")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        response.setHeader("Set-Cookie", "sessionId=" + sessionId + "; SameSite=none; Secure");

        user.setPassword("");
        return user;
    }

    @GetMapping("/fetchUser")
    public User fetchUser(@CookieValue("sessionId") String sessionId) {
        return accessService.fetchUser(sessionId.split("$")[0]);
    }
}
