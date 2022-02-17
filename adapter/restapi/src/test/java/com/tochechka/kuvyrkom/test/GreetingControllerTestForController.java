package com.tochechka.kuvyrkom.test;

import org.junit.Test;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class GreetingControllerTestForController extends BaseTestForController {

    @Test
    public void greeting() throws Exception {
        ResultActions result = mvc.perform(get("/"));
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(content().string(containsString("Погнали!")));
    }
}
