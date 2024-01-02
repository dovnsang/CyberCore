package com.fa.cybercore.controller;

import com.fa.cybercore.model.SuDungMay;
import com.fa.cybercore.repository.KhachHangRepository;
import com.fa.cybercore.repository.MayRepository;
import com.fa.cybercore.repository.SuDungMayRepository;
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
import java.util.stream.Collectors;

/**
 * @author: Sang
 * @date: 1/2/2024
 */

@Controller
@RequestMapping("/sudungmay")
@RequiredArgsConstructor
public class SuDungMayController {
    private final SuDungMayRepository suDungMayRepository;
    private final MayRepository mayRepository;
    private final KhachHangRepository khachHangRepository;

    @GetMapping
    public String show(Model model) {
        model.addAttribute("mayList", mayRepository.findAll());
        model.addAttribute("khachHangList", khachHangRepository.findAll());
        model.addAttribute("suDungMay", new SuDungMay());

        return "may/use";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("suDungMay") SuDungMay suDungMay,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("mayList", mayRepository.findAll());
            model.addAttribute("khachHangList", khachHangRepository.findAll());
            model.addAttribute("suDungMay", suDungMay);
            model.addAttribute("error", bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)));
            return "may/use";
        }
        suDungMayRepository.save(suDungMay);
        redirectAttributes.addFlashAttribute("successMessage", "Sử dụng máy thành công.");
        return "redirect:/sudungmay";
    }
}
