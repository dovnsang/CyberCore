package com.fa.cybercore.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Table(name = "SUDUNGMAY")
@Entity
@Data
public class SuDungMay {
    @EmbeddedId
    private SuDungMayId id;

    @ManyToOne
    @JoinColumn(name = "MaKH", insertable = false, updatable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "MaMay", insertable = false, updatable = false)
    private May may;

    @Column(name = "ThoiGianSuDung")
    private long thoiGianSuDung;
}
