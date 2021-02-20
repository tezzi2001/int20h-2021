package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.entity.User;
import com.bondarenko.int20h2021.domain.json.UserWithSession;
import com.bondarenko.int20h2021.service.AccessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class AccessController {
    private final AccessService accessService;

    @PostMapping("/signIn")
    public UserWithSession signIn(@RequestBody User user, HttpServletResponse response) {
        String sessionId = accessService.signIn(user.getLogin(), user.getPassword());
        if (sessionId.equals("")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        Cookie cookie = new Cookie("sessionId", sessionId);
        response.addCookie(cookie);

        user.setPassword("");
        return new UserWithSession(user.getLogin(), user.getPassword(), sessionId);
    }

    @PostMapping("/signUp")
    public User signUp(@RequestBody User user, HttpServletResponse response) {
        boolean result = accessService.signUp(user.getLogin(), user.getPassword());

        if (!result) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        user.setPassword("");
        return user;
    }
}
