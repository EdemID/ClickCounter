package com.tochechka.kuvyrkom.test;

import org.junit.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ClickControllerTestForController extends BaseTestForController {

    @Test
    public void counter() throws Exception {
        mvc.perform(get("/counter"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(content().string(containsString("Счетчик кликов")));
    }

    @Test
    public void incrementClick() throws Exception {
        mvc.perform(get("/counter/click"))
                .andExpect(redirectedUrl("/counter"));
    }

    @Test
    public void startOver() throws Exception {
        mvc.perform(get("/counter/startover"))
                .andExpect(redirectedUrl("/counter"));
    }
}
