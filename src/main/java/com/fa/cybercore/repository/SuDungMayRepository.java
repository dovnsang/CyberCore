package com.fa.cybercore.repository;

import com.fa.cybercore.model.SuDungMay;
import com.fa.cybercore.model.SuDungMayId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Sang
 * @date: 1/2/2024
 */

@Repository
public interface SuDungMayRepository extends JpaRepository<SuDungMay, SuDungMayId> {
}
