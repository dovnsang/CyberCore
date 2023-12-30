package com.fa.cybercore.controller;

import com.fa.cybercore.model.KhachHang;
import com.fa.cybercore.repository.KhachHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Sang
 * @date: 12/29/2023
 */

@Controller
@RequestMapping("/khachhang")
@RequiredArgsConstructor
public class KhachHangController {
    private final KhachHangRepository khachHangRepository;


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        model.addAttribute("successMessage", model.getAttribute("successMessage"));
        return "/khachhang/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("khachHang") KhachHang khachHang,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        Map<String, String> errors = new HashMap<>();

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        } else if (khachHangRepository.existsByMaKH(khachHang.getMaKH())) {
            errors.put("maKH", "Mã khách hàng đã tồn tại.");
        }

        if (!errors.isEmpty()) {
            model.addAttribute("khachHang", khachHang);
            model.addAttribute("error", errors);
            return "/khachhang/create";
        }
        khachHangRepository.save(khachHang);
        redirectAttributes.addFlashAttribute("successMessage", "Tạo khách hàng thành công.");
        return "redirect:/khachhang/create";
    }
}