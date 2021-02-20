package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.json.Cities;
import com.bondarenko.int20h2021.domain.json.Pets;
import com.bondarenko.int20h2021.service.FilterFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FilterFetchController {
    private final FilterFetchService filterFetchService;

    @GetMapping("/cities")
    public Cities getCities() {
        return filterFetchService.getCities();
    }

    @GetMapping("/pets")
    public Pets getPets() {
        return filterFetchService.getPets();
    }
}
