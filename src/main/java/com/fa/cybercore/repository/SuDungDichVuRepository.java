package com.fa.cybercore.repository;

import com.fa.cybercore.model.SuDungDichVu;
import com.fa.cybercore.model.SuDungDichVuId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Sang
 * @date: 1/2/2024
 */

@Repository
public interface SuDungDichVuRepository extends JpaRepository<SuDungDichVu, SuDungDichVuId> {
}
