package com.bondarenko.int20h2021.domain.json;

import com.bondarenko.int20h2021.domain.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserWithSession extends User {
    private final String sessionId;

    public UserWithSession(String login, String password, String sessionId) {
        super(login, password);
        this.sessionId = sessionId;
    }
}
