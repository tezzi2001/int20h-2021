package com.bondarenko.int20h2021.domain.json;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserWithSessionId {
    private UserWithIds userData;

    private String token;
}
