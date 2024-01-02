package com.fa.cybercore.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: Sang
 * @date: 1/2/2024
 */

@Data
public class SuDungMayDto {
    @NotBlank(message = "Vui lòng chọn mã khách hàng.")
    private String maKH;

    @NotBlank(message = "Vui lòng chọn mã máy.")
    private String maMay;

    @NotBlank(message = "Vui lòng chọn ngày bắt đầu sử dụng.")
    private String ngayBatDauSuDung;

    @NotBlank(message = "Vui lòng chọn giờ bắt đầu sử dụng.")
    private String gioBatDauSuDung;

    @NotBlank(message = "Vui lòng nhập thời gian sử dụng.")
    private String thoiGianSuDung;
}
