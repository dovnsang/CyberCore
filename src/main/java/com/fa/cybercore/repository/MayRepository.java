package com.fa.cybercore.repository;

import com.fa.cybercore.model.May;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Repository
public interface MayRepository extends JpaRepository<May, String> {
}
