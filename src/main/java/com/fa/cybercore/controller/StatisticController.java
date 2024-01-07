package com.fa.cybercore.controller;

import com.fa.cybercore.dto.StatisticDto;
import com.fa.cybercore.model.SuDungDichVu;
import com.fa.cybercore.model.SuDungMay;
import com.fa.cybercore.repository.SuDungDichVuRepository;
import com.fa.cybercore.repository.SuDungMayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Sang
 * @date: 1/2/2024
 */

@Controller
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {
    private final SuDungMayRepository suDungMayRepository;
    private final SuDungDichVuRepository suDungDichVuRepository;

    @GetMapping
    public String show(Model model) {
        List<SuDungMay> suDungMayList = suDungMayRepository.findAll();
        List<SuDungDichVu> suDungDichVuList = suDungDichVuRepository.findAll();
        List<StatisticDto> statisticDtoList = new ArrayList<>();

        StatisticDto dto;
        for (SuDungMay suDungMay : suDungMayList) {
            dto = new StatisticDto();
            dto.setMaKH(suDungMay.getId().getMaKH());
            dto.setTenKH(suDungMay.getKhachHang().getTenKH());
            dto.setMaMay(suDungMay.getId().getMaMay());
            dto.setViTri(suDungMay.getMay().getViTri());
            dto.setTrangThai(suDungMay.getMay().getTrangThai());
            dto.setNgayBatDauSuDung(suDungMay.getId().getNgayBatDauSuDung());
            dto.setGioBatDauSuDung(suDungMay.getId().getGioBatDauSuDung());
            dto.setThoiGianSuDung(suDungMay.getThoiGianSuDung());
            statisticDtoList.add(dto);
        }

        for (SuDungDichVu suDungDichVu : suDungDichVuList) {
            dto = new StatisticDto();
            dto.setMaKH(suDungDichVu.getId().getMaKH());
            dto.setTenKH(suDungDichVu.getKhachHang().getTenKH());
            dto.setMaDV(suDungDichVu.getId().getMaDV());
            dto.setTenDV(suDungDichVu.getDichVu().getTenDV());
            dto.setNgaySuDung(suDungDichVu.getId().getNgaySuDung());
            dto.setGioSuDung(suDungDichVu.getId().getGioSuDung());
            dto.setSoLuong(suDungDichVu.getSoLuong());
            dto.setTongTien(suDungDichVu.getSoLuong() * suDungDichVu.getDichVu().getDonGia());
            statisticDtoList.add(dto);
        }

        statisticDtoList.sort(Comparator.comparing(StatisticDto::getMaKH)
//                .thenComparing(Comparator.comparing(StatisticDto::getTenKH))
//                .thenComparing(Comparator.comparing(StatisticDto::getMaMay))
//                .thenComparing(Comparator.comparing(StatisticDto::getNgayBatDauSuDung))
//                .thenComparing(Comparator.comparing(StatisticDto::getGioBatDauSuDung))
//                .thenComparing(Comparator.comparing(StatisticDto::getMaDV))
//                .thenComparing(Comparator.comparing(StatisticDto::getNgaySuDung))
//                .thenComparing(Comparator.comparing(StatisticDto::getGioSuDung))
        );

        model.addAttribute("dtoList", statisticDtoList);

        return "statistic";
    }
}
