package com.fa.cybercore.controller;

import com.fa.cybercore.model.May;
import com.fa.cybercore.repository.MayRepository;
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
@RequestMapping("/may")
@RequiredArgsConstructor
public class MayController {
    private final MayRepository mayRepository;


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("may", new May());
        return "may/create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute("may") @Valid May may,
                       BindingResult bindingResult,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("may", may);
            model.addAttribute("error", errors);
            return "/may/create";
        }
        mayRepository.save(may);
        redirectAttributes.addFlashAttribute("successMessage", "Tạo mới máy thành công.");
        return "redirect:/may/create";
    }
}
