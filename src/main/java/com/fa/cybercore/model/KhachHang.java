package com.fa.cybercore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Table(name = "KHACHHANG")
@Entity
@Getter
@Setter
public class KhachHang {
    @Id
    @NotBlank(message = "Vui lòng nhập mã khách hàng.")
    @Pattern(regexp = "^KH[0-9]{3}$", message = "Vui lòng nhập đúng định dạng mã khách hàng. Ví dụ: KH001")
    @Column(name = "MaKH")
    private String maKH;

    @NotBlank(message = "Vui lòng nhập tên khách hàng.")
    @Column(name = "TenKH", columnDefinition = "nvarchar(255)")
    private String tenKH;

    @NotBlank(message = "Vui lòng nhập địa chỉ.")
    @Column(name = "DiaChi", columnDefinition = "nvarchar(255)")
    private String diaChi;

    @NotBlank(message = "Vui lòng nhập số điện thoại.")
    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @NotBlank(message = "Vui lòng nhập địa chỉ Email.")
    @Column(name = "DiaChiEmail")
    private String diaChiEmail;

    @OneToMany(mappedBy = "khachHang")
    @JsonIgnoreProperties("khachHang")
    private List<SuDungMay> suDungMayList;

    @OneToMany(mappedBy = "khachHang")
    @JsonIgnoreProperties("khachHang")
    private List<SuDungDichVu> suDungDichVuList;
}
