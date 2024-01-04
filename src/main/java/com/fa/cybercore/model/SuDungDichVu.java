package com.fa.cybercore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Table(name = "SUDUNGDICHVU")
@Entity
@Getter
@Setter
public class SuDungDichVu {
    @EmbeddedId
    @Valid
    private SuDungDichVuId id;

    @ManyToOne
    @JoinColumn(name = "MaKH", insertable = false, updatable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "MaDV", insertable = false, updatable = false)
    private DichVu dichVu;

    @Column(name = "SoLuong")
    @NotNull(message = "Vui lòng nhập số luợng.")
    @Min(value = 1, message = "Số lượng phải lớn hơn 0.")
    private Integer soLuong;
}
