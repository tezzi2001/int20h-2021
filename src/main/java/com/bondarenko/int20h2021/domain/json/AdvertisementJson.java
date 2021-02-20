package com.bondarenko.int20h2021.domain.json;

import com.bondarenko.int20h2021.domain.entity.AdvertisementFound;
import com.bondarenko.int20h2021.domain.entity.AdvertisementLost;
import com.bondarenko.int20h2021.domain.entity.User;
import lombok.Data;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@Data
public class AdvertisementJson {
    private long id;

    private String title;

    private String description;

    private String photoUrl;

    private String location;

    private String phone;

    private String species;

    private Date date;

    private String user;

    public AdvertisementJson(AdvertisementFound advertisementFound) {
        this.id = advertisementFound.getId();
        this.title = advertisementFound.getTitle();
        this.description = advertisementFound.getDescription();
        this.photoUrl = createPhotoUrl(advertisementFound.getPhoto(), advertisementFound.getPhotoName());
        this.location = advertisementFound.getLocation();
        this.phone = advertisementFound.getPhone();
        this.species = advertisementFound.getSpecies();
        this.date = advertisementFound.getDate();
        User userT = advertisementFound.getUser();
        this.user = userT.getName() + ' ' + userT.getSurname();
    }

    public AdvertisementJson(AdvertisementLost advertisementLost) {
        this.id = advertisementLost.getId();
        this.title = advertisementLost.getTitle();
        this.description = advertisementLost.getDescription();
        this.photoUrl = createPhotoUrl(advertisementLost.getPhoto(), advertisementLost.getPhotoName());
        this.location = advertisementLost.getLocation();
        this.phone = advertisementLost.getPhone();
        this.species = advertisementLost.getSpecies();
        this.date = advertisementLost.getDate();
        User userT = advertisementLost.getUser();
        this.user = userT.getName() + ' ' + userT.getSurname();
    }

    @SneakyThrows
    private String createPhotoUrl(byte[] photo, String photoName) {
        Files.write(Paths.get("download/" + photoName), photo);
        return "";
    }
}
