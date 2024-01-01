package com.fa.cybercore.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author: Sang
 * @date: 12/28/2023
 */

@Table(name = "MAY")
@Entity
@Data
public class May {
    @Id
    @NotBlank(message = "Vui lòng nhập mã máy.")
    @Pattern(regexp = "^MAY[0-9]{2}$", message = "Vui lòng nhập đúng định dạng mã máy. Ví dụ: MAY01")
    @Column(name = "MaMay")
    private String maMay;
    @NotBlank(message = "Vui lòng nhập vị trí máy.")
    @Column(name = "ViTri", columnDefinition = "nvarchar(255)")
    private String viTri;
    @NotBlank(message = "Vui lòng chọn trạng thái máy.")
    @Column(name = "TrangThai", columnDefinition = "nvarchar(50)")
    private String trangThai;
    @OneToMany(mappedBy = "may")
    private List<SuDungMay> suDungMayList;
}
