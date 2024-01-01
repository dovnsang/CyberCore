package com.fa.cybercore.repository;

import com.fa.cybercore.model.DichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Sang
 * @date: 12/30/2023
 */

@Repository
public interface DichVuRepository extends JpaRepository<DichVu, String> {
    boolean existsByMaDV(String maDV);
}
