package com.bondarenko.int20h2021.domain.json;

import com.bondarenko.int20h2021.domain.entity.AdvertisementFound;
import com.bondarenko.int20h2021.domain.entity.AdvertisementLost;
import com.bondarenko.int20h2021.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdvertisementDto {

    private String title;

    private String description;

    private String location;

    private String phone;

    private String species;

    private String url;

    public AdvertisementLost toAdvertisementLost(User user) {
        return new AdvertisementLost(title, description, new byte[0], url, location, phone, species, new Date(), user);
    }

    public AdvertisementFound toAdvertisementFound(User user) {
        return new AdvertisementFound(title, description, new byte[0], url, location, phone, species, new Date(), user);
    }
}
