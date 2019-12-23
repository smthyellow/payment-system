package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
    Optional<OfferEntity> findByOfferId(Long aLong);
}
