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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertisementService {
    private final AdvertisementLostRepository advertisementLostRepository;
    private final AdvertisementFoundRepository advertisementFoundRepository;
    private final UserRepository userRepository;

    public void createAdvertisementLost(AdvertisementDto advertisementDto, String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            advertisementLostRepository.save(advertisementDto.toAdvertisementLost(user));
        }

    }

    public void createAdvertisementFound(AdvertisementDto advertisementDto, String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            advertisementFoundRepository.save(advertisementDto.toAdvertisementFound(user));
        }

    }

    public void deleteAdvertisementLostById(long id) {
        advertisementLostRepository.deleteById(id);
    }

    public void deleteAdvertisementFoundById(long id) {
        advertisementFoundRepository.deleteById(id);
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
