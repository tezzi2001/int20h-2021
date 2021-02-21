package com.bondarenko.int20h2021.domain.json;

import com.bondarenko.int20h2021.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserWithIds {
    private String email;

    private String name;

    private String surname;

    private List<Long> createdLostId;

    private List<Long> createdFoundId;

    public UserWithIds(User user, List<Long> createdLostId, List<Long> createdFoundId) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.createdLostId = createdLostId;
        this.createdFoundId = createdFoundId;
    }
}
