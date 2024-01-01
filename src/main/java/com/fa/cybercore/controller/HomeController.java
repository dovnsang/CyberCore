package com.fa.cybercore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Sang
 * @date: 12/30/2023
 */

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home() {
        return "/index";
    }
}
