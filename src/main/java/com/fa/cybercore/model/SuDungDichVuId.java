package com.fa.cybercore.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Embeddable
@Data
public class SuDungDichVuId implements Serializable {
    @Column(name = "MaKH")
    private String maKH;
    @Column(name = "MaDV")
    private String maDV;
    @Column(name = "NgaySuDung")
    private LocalDate ngaySuDung;
    @Column(name = "GioSuDung")
    private LocalTime gioSuDung;
}
