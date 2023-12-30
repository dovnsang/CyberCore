package com.fa.cybercore.repository;

import com.fa.cybercore.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Sang
 * @date: 12/29/2023
 */

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {
    boolean existsByMaKH(String maKH);
}
