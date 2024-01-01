package com.fa.cybercore.controller;

import com.fa.cybercore.model.DichVu;
import com.fa.cybercore.repository.DichVuRepository;
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
 * @date: 12/30/2023
 */

@Controller
@RequestMapping("/dichvu")
@RequiredArgsConstructor
public class DichVuController {
    private final DichVuRepository dichVuRepository;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("dichVu", new DichVu());
        return "/dichvu/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute("dichVu") DichVu dichVu,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        Map<String, String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        } else if (dichVuRepository.existsByMaDV(dichVu.getMaDV())) {
            errors.put("maDV", "Mã dịch vụ đã tồn tại.");
        }
        if (!errors.isEmpty()) {
            model.addAttribute("dichVu", dichVu);
            model.addAttribute("error", errors);
            return "/dichvu/create";
        }
        dichVuRepository.save(dichVu);
        redirectAttributes.addFlashAttribute("successMessage", "Tạo mới dịch vụ thành công.");
        return "redirect:/dichvu/create";
    }
}
