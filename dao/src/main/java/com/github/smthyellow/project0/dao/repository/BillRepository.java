package com.github.smthyellow.project0.dao.repository;

import com.github.smthyellow.project0.dao.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
}
