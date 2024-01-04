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
public class SuDungDichVuId implements Serializable {
    @Column(name = "MaKH")
    @NotBlank(message = "Vui lòng chọn mã khách hàng.")
    private String maKH;

    @Column(name = "MaDV")
    @NotBlank(message = "Vui lòng chọn mã dịch vụ.")
    private String maDV;

    @Column(name = "NgaySuDung")
    @NotNull(message = "Vui lòng chọn ngày sử dụng dịch vụ.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngaySuDung;

    @Column(name = "GioSuDung")
    @NotNull(message = "Vui lòng chọn giờ sử dụng dịch vụ.")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime gioSuDung;
}
