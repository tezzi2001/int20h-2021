package com.bondarenko.int20h2021.repository;

import com.bondarenko.int20h2021.domain.entity.AdvertisementFound;
import com.bondarenko.int20h2021.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdvertisementFoundRepository extends JpaRepository<AdvertisementFound, Long> {
    List<AdvertisementFound> findAllByUser(User user);
    Optional<AdvertisementFound> findByPhotoName(String url);
}
