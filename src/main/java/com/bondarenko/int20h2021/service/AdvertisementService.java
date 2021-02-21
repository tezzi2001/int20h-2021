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
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
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

    public List<AdvertisementJson> getAllAdvertisementFound(MultiValueMap<String, String> filters) {
        List<AdvertisementFound> advertisementsFound = advertisementFoundRepository.findAll();

        if (filters != null) {
            if (filters.containsKey("city")) {
                List<String> cities = filters.get("city");
                advertisementsFound = advertisementsFound.stream()
                        .filter(advertisementFound -> cities.contains(advertisementFound.getLocation()))
                        .collect(Collectors.toList());
            }

            if (filters.containsKey("pet")) {
                List<String> pets = filters.get("pet");
                advertisementsFound = advertisementsFound.stream()
                        .filter(advertisementFound -> pets.contains(advertisementFound.getSpecies()))
                        .collect(Collectors.toList());
            }
        }

        return advertisementsFound.stream()
                .map(AdvertisementJson::new)
                .sorted((ad2, ad1) -> ad1.getDate().compareTo(ad2.getDate()))
                .collect(Collectors.toList());
    }

    public List<AdvertisementJson> getAllAdvertisementLost(MultiValueMap<String, String> filters) {
        List<AdvertisementLost> advertisementsLost = advertisementLostRepository.findAll();

        if (filters != null) {
            if (filters.containsKey("city")) {
                List<String> cities = filters.get("city");
                advertisementsLost = advertisementsLost.stream()
                        .filter(advertisementLost -> cities.contains(advertisementLost.getLocation()))
                        .collect(Collectors.toList());
            }

            if (filters.containsKey("pet")) {
                List<String> pets = filters.get("pet");
                advertisementsLost = advertisementsLost.stream()
                        .filter(advertisementLost -> pets.contains(advertisementLost.getSpecies()))
                        .collect(Collectors.toList());
            }
        }

        return advertisementsLost.stream()
                .map(AdvertisementJson::new)
                .sorted((ad2, ad1) -> ad1.getDate().compareTo(ad2.getDate()))
                .collect(Collectors.toList());
    }

    public List<Long> getAdvertisementFoundByEmail(String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<AdvertisementFound> advertisementFoundList = advertisementFoundRepository.findAllByUser(user);
            return advertisementFoundList.stream()
                    .sorted((ad2, ad1) -> ad1.getDate().compareTo(ad2.getDate()))
                    .map(AdvertisementFound::getId)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public List<Long> getAdvertisementLostByEmail(String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            List<AdvertisementLost> advertisementLostList = advertisementLostRepository.findAllByUser(user);
            return advertisementLostList.stream()
                    .sorted((ad2, ad1) -> ad1.getDate().compareTo(ad2.getDate()))
                    .map(AdvertisementLost::getId)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public List<AdvertisementJson> searchLost(String[] keyWords) {
        List<AdvertisementJson> allAdvertisementLost = getAllAdvertisementLost(null);
        ArrayList<AdvertisementJson> result = new ArrayList<>();

        for (AdvertisementJson advertisementJson : allAdvertisementLost) {
            for (String keyWord : keyWords) {
                if (advertisementJson.getTitle().contains(keyWord) || advertisementJson.getDescription().contains(keyWord)) {
                    result.add(advertisementJson);
                }
            }
        }

        return result.stream()
                .sorted((ad2, ad1) -> ad1.getDate().compareTo(ad2.getDate()))
                .collect(Collectors.toList());
    }

    public List<AdvertisementJson> searchFound(String[] keyWords) {
        List<AdvertisementJson> allAdvertisementFound = getAllAdvertisementFound(null);
        ArrayList<AdvertisementJson> result = new ArrayList<>();

        for (AdvertisementJson advertisementJson : allAdvertisementFound) {
            for (String keyWord : keyWords) {
                if (advertisementJson.getTitle().contains(keyWord) || advertisementJson.getDescription().contains(keyWord)) {
                    result.add(advertisementJson);
                }
            }
        }

        return result.stream()
                .sorted((ad2, ad1) -> ad1.getDate().compareTo(ad2.getDate()))
                .collect(Collectors.toList());
    }
}
