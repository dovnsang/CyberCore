package com.fa.cybercore.controller;

import com.fa.cybercore.model.KhachHang;
import com.fa.cybercore.repository.KhachHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author: Sang
 * @date: 1/1/2024
 */

@RestController
@RequestMapping("/api/khachhang")
@RequiredArgsConstructor
public class KhachHangRestController {
    private final KhachHangRepository khachHangRepository;

    @GetMapping
    public ResponseEntity<List<KhachHang>> getAll() {
        return new ResponseEntity<>(khachHangRepository.findAll(), HttpStatus.OK);
    }
}
