package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.json.AdvertisementDto;
import com.bondarenko.int20h2021.domain.json.AdvertisementJson;
import com.bondarenko.int20h2021.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @PostMapping("/createAdvertisementLost")
    public void createAdvertisementLost(@RequestBody AdvertisementDto advertisementDto, @CookieValue("sessionId") String sessionId) {
        advertisementService.createAdvertisementLost(advertisementDto, sessionId.split("$")[0]);
    }

    @PostMapping("/createAdvertisementFound")
    public void createAdvertisementFound(@RequestBody AdvertisementDto advertisementDto, @CookieValue("sessionId") String sessionId) {
        advertisementService.createAdvertisementFound(advertisementDto, sessionId.split("$")[0]);
    }

    @GetMapping("/deleteAdvertisementLostById")
    public void deleteAdvertisementLostById(@RequestParam long id, @CookieValue("sessionId") String sessionId) {
        advertisementService.deleteAdvertisementLostById(id, sessionId.split("$")[0]);
    }

    @GetMapping("/deleteAdvertisementFoundById")
    public void deleteAdvertisementFoundById(@RequestParam long id, @CookieValue("sessionId") String sessionId) {
        advertisementService.deleteAdvertisementFoundById(id, sessionId.split("$")[0]);
    }

    @GetMapping("/getAllAdvertisementFoundJson")
    public List<AdvertisementJson> getAllAdvertisementFoundJson() {
        return advertisementService.getAllAdvertisementFoundJson();
    }

    @GetMapping("/getAllAdvertisementLostJson")
    public List<AdvertisementJson> getAllAdvertisementLostJson() {
        return advertisementService.getAllAdvertisementLostJson();
    }
}
