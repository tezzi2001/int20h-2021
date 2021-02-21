package com.bondarenko.int20h2021.repository;

import com.bondarenko.int20h2021.domain.entity.AdvertisementLost;
import com.bondarenko.int20h2021.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisementLostRepository extends JpaRepository<AdvertisementLost, Long> {
    List<AdvertisementLost> findAllByUser(User user);
    Optional<AdvertisementLost> findByPhotoName(String url);
}
