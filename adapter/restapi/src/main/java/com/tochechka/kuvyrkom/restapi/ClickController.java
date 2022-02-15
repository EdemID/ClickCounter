package com.tochechka.kuvyrkom.restapi;

import com.tochechka.kuvyrkom.core.BusinessLogic;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/counter")
@AllArgsConstructor
public class ClickController {

    private BusinessLogic businessLogic;

    @GetMapping(value = "/click", produces = APPLICATION_JSON_VALUE)
    public Long countClick(@RequestParam(value = "id", required = false) Long id) {
        return businessLogic.countClick(id);
    }

    @GetMapping(value = "/show", produces = APPLICATION_JSON_VALUE)
    public Long showCount(@RequestParam(value = "id", required = false) Long id) {
        return businessLogic.showCount(id);
    }
}
