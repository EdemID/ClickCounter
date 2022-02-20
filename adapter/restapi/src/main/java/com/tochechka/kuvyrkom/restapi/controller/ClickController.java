package com.tochechka.kuvyrkom.restapi.controller;

import com.tochechka.kuvyrkom.core.BusinessLogic;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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

    @GetMapping(value = "/incrementClickByTwoWithNativeQuery")
    public String incrementClickByTwoWithNativeQuery(@RequestParam(value = "id", defaultValue = "1") Long id, Model model) {
        model.addAttribute("count", businessLogic.incrementClickByTwoWithNativeQuery(id));
        return "redirect:/counter";
    }

    @GetMapping(value = "/incrementClickByThreeWithJdbcTemplate")
    public String incrementClickByThreeWithJdbcTemplate() {
        businessLogic.incrementClickByThreeWithJdbcTemplate();
        return "redirect:/counter";
    }

    @ResponseBody
    @GetMapping(value = "/incrementClickAndReturnJsonResponse", produces = APPLICATION_JSON_VALUE)
    public Long incrementClickAndReturnJsonResponse(@RequestParam(value = "id", defaultValue = "1") Long id) {
        return businessLogic.incrementClick(id);
    }
}
