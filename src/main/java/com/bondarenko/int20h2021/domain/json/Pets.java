package com.bondarenko.int20h2021.domain.json;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pets {
    private List<Pet> pets;
}
