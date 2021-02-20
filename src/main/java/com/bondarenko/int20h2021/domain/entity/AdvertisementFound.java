package com.bondarenko.int20h2021.domain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
public class AdvertisementFound {
    @Id
    @GeneratedValue
    private long id;

    private String title;

    private String description;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    private String photoName;

    private String location;

    private String phone;

    private String species;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public AdvertisementFound(String title, String description, byte[] photo, String photoName, String location, String phone, String species, Date date, User user) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.photoName = photoName;
        this.location = location;
        this.phone = phone;
        this.species = species;
        this.date = date;
        this.user = user;
    }
}
