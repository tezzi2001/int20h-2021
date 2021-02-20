package com.bondarenko.int20h2021.service;

import com.bondarenko.int20h2021.domain.entity.AdvertisementFound;
import com.bondarenko.int20h2021.domain.entity.AdvertisementLost;
import com.bondarenko.int20h2021.domain.entity.User;
import com.bondarenko.int20h2021.domain.json.AdvertisementDto;
import com.bondarenko.int20h2021.domain.json.AdvertisementJson;
import com.bondarenko.int20h2021.repository.AdvertisementFoundRepository;
import com.bondarenko.int20h2021.repository.AdvertisementLostRepository;
import com.bondarenko.int20h2021.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertisementService {
    private final AdvertisementLostRepository advertisementLostRepository;
    private final AdvertisementFoundRepository advertisementFoundRepository;
    private final UserRepository userRepository;

    public void createAdvertisementLost(AdvertisementDto advertisementDto, MultipartFile photo, String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            advertisementLostRepository.save(advertisementDto.toAdvertisementLost(user, photo));
        }

    }

    public void createAdvertisementFound(AdvertisementDto advertisementDto, MultipartFile photo, String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            advertisementFoundRepository.save(advertisementDto.toAdvertisementFound(user, photo));
        }

    }

    public void deleteAdvertisementLostById(long id, String email) {
        Optional<AdvertisementLost> advertisementLostOptional = advertisementLostRepository.findById(id);
        if (advertisementLostOptional.isPresent()) {
            AdvertisementLost advertisementLost = advertisementLostOptional.get();
            if (advertisementLost.getUser().getEmail().equals(email)) {
                advertisementLostRepository.deleteById(id);
            }
        }
    }

    public void deleteAdvertisementFoundById(long id, String email) {
        Optional<AdvertisementFound> advertisementFoundOptional = advertisementFoundRepository.findById(id);
        if (advertisementFoundOptional.isPresent()) {
            AdvertisementFound advertisementFound = advertisementFoundOptional.get();
            if (advertisementFound.getUser().getEmail().equals(email)) {
                advertisementFoundRepository.deleteById(id);
            }
        }
    }

    public List<AdvertisementJson> getAllAdvertisementFoundJson() {
        List<AdvertisementFound> advertisementsFound = advertisementFoundRepository.findAll();
        return advertisementsFound.stream()
                .map(AdvertisementJson::new)
                .collect(Collectors.toList());
    }

    public List<AdvertisementJson> getAllAdvertisementLostJson() {
        List<AdvertisementLost> advertisementsLost = advertisementLostRepository.findAll();
        return advertisementsLost.stream()
                .map(AdvertisementJson::new)
                .collect(Collectors.toList());
    }
}
