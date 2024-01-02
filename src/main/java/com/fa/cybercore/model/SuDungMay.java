package com.fa.cybercore.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Table(name = "SUDUNGMAY")
@Entity
@Data
public class SuDungMay {
    @EmbeddedId
    @Valid
    private SuDungMayId id;

    @ManyToOne
    @JoinColumn(name = "MaKH", insertable = false, updatable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "MaMay", insertable = false, updatable = false)
    private May may;

    @Column(name = "ThoiGianSuDung")
    @NotNull(message = "Vui lòng nhập thời gian sử dụng.")
    @Min(value = 1, message = "Thời gian sử dụng phải lớn hơn 0.")
    private Long thoiGianSuDung;
}
