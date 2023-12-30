package com.fa.cybercore.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Table(name = "DICHVU")
@Entity
@Data
public class DichVu {

    @Id
    @Column(name = "MaDV")
    private String maDV;
    @Column(name = "TenDV", columnDefinition = "nvarchar(255)")
    private String tenDV;
    @Column(name = "DonViTinh")
    private String donViTinh;
    @Column(name = "DonGia")
    private double donGia;
    @OneToMany(mappedBy = "dichVu")
    private List<SuDungDichVu> suDungDichVuList;
}
