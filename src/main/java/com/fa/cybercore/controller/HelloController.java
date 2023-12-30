package com.fa.cybercore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Sang
 * @date: 12/27/2023
 */

@Controller
public class HelloController {
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "hello da nang");
        return "hello";
    }
    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("message", "");
        return "test/test";
    }
}