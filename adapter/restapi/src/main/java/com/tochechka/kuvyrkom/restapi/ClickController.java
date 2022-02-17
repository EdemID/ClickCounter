package com.tochechka.kuvyrkom.restapi;

import com.tochechka.kuvyrkom.core.BusinessLogic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/counter")
@AllArgsConstructor
public class ClickController {

    private BusinessLogic businessLogic;

    @GetMapping
    public String counter(@RequestParam(value = "id", defaultValue = "1") Long id, Model model) {
        model.addAttribute("count", businessLogic.showCount(id));
        return "counter";
    }

    @GetMapping(value = "/click")
    public String incrementClick(@RequestParam(value = "id", defaultValue = "1") Long id, Model model) {
        model.addAttribute("count", businessLogic.incrementClick(id));
        return "redirect:/counter";
    }

    @GetMapping(value = "/startover")
    public String startOver(@RequestParam(value = "id", defaultValue = "1") Long id, Model model) {
        model.addAttribute("count", businessLogic.startOver(id));
        return "redirect:/counter";
    }
}
