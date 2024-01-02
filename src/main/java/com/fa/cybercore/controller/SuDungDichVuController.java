package com.fa.cybercore.controller;

import com.fa.cybercore.model.DichVu;
import com.fa.cybercore.model.KhachHang;
import com.fa.cybercore.model.SuDungDichVu;
import com.fa.cybercore.repository.DichVuRepository;
import com.fa.cybercore.repository.KhachHangRepository;
import com.fa.cybercore.repository.SuDungDichVuRepository;
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
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Sang
 * @date: 1/2/2024
 */
@Controller
@RequestMapping("/sudungdichvu")
@RequiredArgsConstructor
public class SuDungDichVuController {
    private final SuDungDichVuRepository suDungDichVuRepository;
    private final KhachHangRepository khachHangRepository;
    private final DichVuRepository dichVuRepository;

    @ModelAttribute("khachHangList")
    public List<KhachHang> getKhachHangList() {
        return khachHangRepository.findAll();
    }

    @ModelAttribute("dichVuList")
    public List<DichVu> getDichVuList() {
        return dichVuRepository.findAll();
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("suDungDichVu", new SuDungDichVu());
        return "dichvu/use";
    }

    @PostMapping
    public String save(
            @ModelAttribute("suDungDichVu") @Valid SuDungDichVu suDungDichVu,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("suDungDichVu", suDungDichVu);
            model.addAttribute("error", bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
            return "dichvu/use";
        }
        suDungDichVuRepository.save(suDungDichVu);
        redirectAttributes.addFlashAttribute("successMessage", "Sử dụng dịch vụ thành công.");
        return "redirect:/sudungdichvu";
    }
}
