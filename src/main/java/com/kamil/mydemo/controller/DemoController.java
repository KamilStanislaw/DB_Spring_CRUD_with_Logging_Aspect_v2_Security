package com.kamil.mydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    // request mapping for /leaders

    @GetMapping("/manager")
    public String showLeaders() {

        return "managers";
    }

    // request mapping for /systems

    @GetMapping("/admin")
    public String showSystems() {

        return "admins";
    }

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }

}
