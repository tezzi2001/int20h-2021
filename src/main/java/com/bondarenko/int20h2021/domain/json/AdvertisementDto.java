package com.bondarenko.int20h2021.domain.json;

import com.bondarenko.int20h2021.domain.entity.AdvertisementFound;
import com.bondarenko.int20h2021.domain.entity.AdvertisementLost;
import com.bondarenko.int20h2021.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @SneakyThrows
    public AdvertisementLost toAdvertisementLost(User user, MultipartFile photo) {
        Byte[] bytes;
        String originalFileName;

        if (photo == null) {
            bytes = null;
            originalFileName = null;
        } else {
            bytes = getByteObjects(photo);
            originalFileName = photo.getOriginalFilename();
        }

        return new AdvertisementLost(title, description, bytes, originalFileName, location, phone, species, new Date(), user);
    }

    @SneakyThrows
    public AdvertisementFound toAdvertisementFound(User user, MultipartFile photo) {
        byte[] bytes;
        String originalFileName;

        if (photo == null) {
            bytes = null;
            originalFileName = null;
        } else {
            bytes = photo.getBytes();
            originalFileName = photo.getOriginalFilename();
        }

        return new AdvertisementFound(title, description, bytes, originalFileName, location, phone, species, new Date(), user);
    }

    private Byte[] getByteObjects(MultipartFile file) {
        try {
            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }
            return byteObjects;
        } catch (IOException e) {
            e.printStackTrace();
            return new Byte[0];
        }
    }
}
