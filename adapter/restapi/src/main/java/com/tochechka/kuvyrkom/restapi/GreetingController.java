package com.tochechka.kuvyrkom.restapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "друг") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
