package com.fa.cybercore.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Table(name = "SUDUNGDICHVU")
@Entity
@Data
public class SuDungDichVu {
    @EmbeddedId
    private SuDungDichVuId id;
    @ManyToOne
    @JoinColumn(name = "MaKH", insertable = false, updatable = false)
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "MaDV", insertable = false, updatable = false)
    private DichVu dichVu;
    @Column(name = "SoLuong")
    private int soLuong;
}
