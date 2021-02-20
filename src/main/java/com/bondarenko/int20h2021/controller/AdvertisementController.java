package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.json.AdvertisementDto;
import com.bondarenko.int20h2021.domain.json.AdvertisementJson;
import com.bondarenko.int20h2021.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @PostMapping("/createAdvertisementLost")
    public void createAdvertisementLost(@RequestBody AdvertisementDto advertisementDto) {
        advertisementService.createAdvertisementLost(advertisementDto, advertisementDto.getEmail());
    }

    @PostMapping("/createAdvertisementFound")
    public void createAdvertisementFound(@RequestBody AdvertisementDto advertisementDto) {
        advertisementService.createAdvertisementFound(advertisementDto, advertisementDto.getEmail());
    }

    public void deleteAdvertisementLostById(long id) {
        advertisementService.deleteAdvertisementLostById(id);
    }

    public void deleteAdvertisementFoundById(long id) {
        advertisementService.deleteAdvertisementFoundById(id);
    }

    public List<AdvertisementJson> getAllAdvertisementFoundJson() {
        return advertisementService.getAllAdvertisementFoundJson();
    }

    public List<AdvertisementJson> getAllAdvertisementLostJson() {
        return advertisementService.getAllAdvertisementLostJson();
    }
}
