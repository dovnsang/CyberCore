package com.fa.cybercore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Embeddable
@Getter
@Setter
public class SuDungMayId implements Serializable {
    @Column(name = "MaKH")
    @NotBlank(message = "Vui lòng chọn mã khách hàng.")
    private String maKH;

    @Column(name = "MaMay")
    @NotBlank(message = "Vui lòng chọn mã máy.")
    private String maMay;

    @Column(name = "NgayBatDauSuDung")
    @NotNull(message = "Vui lòng chọn ngày bắt đầu sử dụng.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayBatDauSuDung;

    @Column(name = "GioBatDauSuDung")
    @NotNull(message = "Vui lòng chọn giờ bắt đầu sử dụng.")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime gioBatDauSuDung;
}
