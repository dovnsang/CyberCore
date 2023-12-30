package com.fa.cybercore.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Embeddable
@Data
public class SuDungMayId implements Serializable {
    @JoinColumn(name = "MaKH")
    private String maKH;
    @JoinColumn(name = "MaMay")
    private String maMay;
    @Column(name = "NgayBatDauSuDung")
    private LocalDate ngayBatDauSuDung;
    @Column(name = "GioBatDauSuDung")
    private LocalTime gioBatDauSuDung;
}
