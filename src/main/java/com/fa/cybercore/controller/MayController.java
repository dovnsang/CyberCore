package com.fa.cybercore.controller;

import com.fa.cybercore.model.May;
import com.fa.cybercore.repository.MayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
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
        Map<String, String> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
        } else if (mayRepository.existsByMaMay(may.getMaMay())) {
            errors.put("maMay", "Mã máy đã tồn tại.");
        }
        if (!errors.isEmpty()) {
            model.addAttribute("may", may);
            model.addAttribute("error", errors);
            return "may/create";
        }
        mayRepository.save(may);
        redirectAttributes.addFlashAttribute("successMessage", "Tạo mới máy thành công.");
        return "redirect:/may/create";
    }

    @GetMapping
    public String showAll(@RequestParam(value = "q", required = false) String query,
                          Pageable pageable,
                          Model model) {
        Page<May> mayPage = mayRepository.findAll(query == null ? "" : query, pageable);

        model.addAttribute("query", query);
        model.addAttribute("itemList", mayPage.getContent());
        model.addAttribute("currentPage", mayPage.getNumber());
        model.addAttribute("pageSize", mayPage.getSize());
        model.addAttribute("totalPages", mayPage.getTotalPages());
        return "may/showAll";
    }

    @GetMapping("/update/{maMay}")
    public String edit(@PathVariable("maMay") String maMay,
                       Model model) {
        model.addAttribute("may", mayRepository.findByMaMay(maMay));
        return "may/update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("may") May may,
                         BindingResult bindingResult,
                         Model model,
                         RedirectAttributes redirectAttributes) {
        Map<String, String> errors = new HashMap<>();

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            model.addAttribute("error", errors);
            model.addAttribute("may", may);
            return "may/update/" + may.getMaMay();
        }

        mayRepository.save(may);
        redirectAttributes.addFlashAttribute("successMessage", "Cập nhật máy thành công.");
        return "redirect:/may/update/" + may.getMaMay();
    }

    @GetMapping("/delete/{maMay}")
    public String delete(@PathVariable("maMay") String maMay) {
        mayRepository.delete(mayRepository.findByMaMay(maMay));
        return "redirect:/may";
    }
}
