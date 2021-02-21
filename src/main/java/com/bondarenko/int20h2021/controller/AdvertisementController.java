package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.json.AdvertisementDto;
import com.bondarenko.int20h2021.domain.json.AdvertisementJson;
import com.bondarenko.int20h2021.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.bondarenko.int20h2021.filter.AddCorsResponseHeaderFilter.getAuthorizationHeader;

@RestController
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @PostMapping("/createAdvertisementLost")
    public void createAdvertisementLost(@RequestBody AdvertisementDto advertisementDto, HttpServletRequest request) {
        advertisementService.createAdvertisementLost(advertisementDto, getAuthorizationHeader(request));
    }

    @PostMapping("/createAdvertisementFound")
    public void createAdvertisementFound(@RequestBody AdvertisementDto advertisementDto, HttpServletRequest request) {
        advertisementService.createAdvertisementFound(advertisementDto, getAuthorizationHeader(request));
    }

    @GetMapping("/deleteAdvertisementLostById")
    public void deleteAdvertisementLostById(@RequestParam long id, HttpServletRequest request) {
        advertisementService.deleteAdvertisementLostById(id, getAuthorizationHeader(request));
    }

    @GetMapping("/deleteAdvertisementFoundById")
    public void deleteAdvertisementFoundById(@RequestParam long id, HttpServletRequest request) {
        advertisementService.deleteAdvertisementFoundById(id, getAuthorizationHeader(request));
    }

    @GetMapping("/getAllAdvertisementFound")
    public List<AdvertisementJson> getAllAdvertisementFound(@RequestParam MultiValueMap<String, String> filters) {
        return advertisementService.getAllAdvertisementFound(filters);
    }

    @GetMapping("/getAllAdvertisementLost")
    public List<AdvertisementJson> getAllAdvertisementLost(@RequestParam MultiValueMap<String, String> filters) {
        return advertisementService.getAllAdvertisementLost(filters);
    }
}
