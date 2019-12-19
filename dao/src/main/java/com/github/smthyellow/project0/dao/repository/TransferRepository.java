package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferEntity, Long> {
}
