package com.bondarenko.int20h2021.domain.json;

import com.bondarenko.int20h2021.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserWithSessionId {
    private User userData;

    private String token;
}
