package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
    Optional<BillEntity> findByBillId(Long aLong);
}
