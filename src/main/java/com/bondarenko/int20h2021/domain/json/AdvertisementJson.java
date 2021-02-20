package com.bondarenko.int20h2021.domain.json;

import com.bondarenko.int20h2021.domain.entity.AdvertisementFound;
import com.bondarenko.int20h2021.domain.entity.AdvertisementLost;

public class AdvertisementJson {
    private long id;

    private String title;

    private String description;

    private String photoUrl;

    private String location;

    private String phone;

    private String species;

    private String user;

    public AdvertisementJson(AdvertisementFound advertisementFound) {

    }

    public AdvertisementJson(AdvertisementLost advertisementLost) {

    }
}
