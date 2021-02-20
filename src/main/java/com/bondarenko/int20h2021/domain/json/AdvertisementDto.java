package com.bondarenko.int20h2021.domain.json;

import com.bondarenko.int20h2021.domain.entity.AdvertisementFound;
import com.bondarenko.int20h2021.domain.entity.AdvertisementLost;
import com.bondarenko.int20h2021.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdvertisementDto {

    private String title;

    private String description;

    private MultipartFile photo;

    private String location;

    private String phone;

    private String species;

    private String email;

    @SneakyThrows
    public AdvertisementLost toAdvertisementLost(User user) {
        return new AdvertisementLost(title, description, photo.getBytes(), photo.getOriginalFilename(), location, phone, species, user);
    }

    @SneakyThrows
    public AdvertisementFound toAdvertisementFound(User user) {
        return new AdvertisementFound(title, description, photo.getBytes(), photo.getOriginalFilename(), location, phone, species, user);
    }
}
