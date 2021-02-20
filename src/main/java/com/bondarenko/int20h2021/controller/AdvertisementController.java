package com.bondarenko.int20h2021.controller;

import com.bondarenko.int20h2021.domain.json.AdvertisementDto;
import com.bondarenko.int20h2021.domain.json.AdvertisementJson;
import com.bondarenko.int20h2021.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.bondarenko.int20h2021.filter.AddCorsResponseHeaderFilter.getAuthorizationHeader;

@RestController
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @PostMapping("/createAdvertisementLost")
    public void createAdvertisementLost(@RequestParam("advertisement") String advertisement, @RequestParam("photo") MultipartFile photo, HttpServletRequest request) {
        System.out.println("advertisement " + advertisement);
        System.out.println("photo " + photo.getOriginalFilename());
//        advertisementService.createAdvertisementLost(advertisementDto, photo, getAuthorizationHeader(request));
    }

    @PostMapping("/createAdvertisementFound")
    public void createAdvertisementFound(@RequestParam("advertisement") AdvertisementDto advertisementDto, @RequestParam("photo") MultipartFile photo, HttpServletRequest request) {
        advertisementService.createAdvertisementFound(advertisementDto, photo, getAuthorizationHeader(request));
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

    @PostMapping("/uploadImg")
    public void uploadImg(MultipartFile photo) {
        System.out.println("filename:" + photo.getOriginalFilename());
    }
}
