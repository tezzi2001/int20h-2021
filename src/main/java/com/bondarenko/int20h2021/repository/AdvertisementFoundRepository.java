package com.bondarenko.int20h2021.repository;

import com.bondarenko.int20h2021.domain.entity.AdvertisementFound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementFoundRepository extends JpaRepository<AdvertisementFound, Long> {
}
