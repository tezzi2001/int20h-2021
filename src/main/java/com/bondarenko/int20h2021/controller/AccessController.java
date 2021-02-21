package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.entity.User;
import com.bondarenko.int20h2021.domain.json.UserWithIds;
import com.bondarenko.int20h2021.domain.json.UserWithSessionId;
import com.bondarenko.int20h2021.service.AccessService;
import com.bondarenko.int20h2021.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.bondarenko.int20h2021.filter.AddCorsResponseHeaderFilter.getAuthorizationHeader;

@RestController
@RequiredArgsConstructor
public class AccessController {
    private final AccessService accessService;
    private final AdvertisementService advertisementService;

    @PostMapping("/authentication")
    public UserWithSessionId signIn(@RequestBody User user, HttpServletResponse response) {
        String sessionId = accessService.signIn(user);

        if (sessionId.equals("")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        String email = user.getEmail();
        return new UserWithSessionId(new UserWithIds(user, advertisementService.getAdvertisementLostByEmail(email), advertisementService.getAdvertisementFoundByEmail(email)), sessionId);
    }

    @PostMapping("/registration")
    public UserWithSessionId signUp(@RequestBody User user, HttpServletResponse response) {
        String sessionId = accessService.signUp(user.getEmail(), user.getPassword(), user.getName(), user.getSurname());

        if (sessionId.equals("")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        String email = user.getEmail();
        return new UserWithSessionId(new UserWithIds(user, advertisementService.getAdvertisementLostByEmail(email), advertisementService.getAdvertisementFoundByEmail(email)), sessionId);
    }

    @GetMapping("/fetchUser")
    public UserWithIds fetchUser(HttpServletRequest request) {
        String s = getAuthorizationHeader(request);
        User user = accessService.fetchUser(s);
        String email = user.getEmail();
        return new UserWithIds(user, advertisementService.getAdvertisementLostByEmail(email), advertisementService.getAdvertisementFoundByEmail(email));
    }
}
