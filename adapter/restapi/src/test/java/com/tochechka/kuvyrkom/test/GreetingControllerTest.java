package com.tochechka.kuvyrkom.test;

import com.tochechka.kuvyrkom.restapi.GreetingController;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = {GreetingController.class})
@WebMvcTest({GreetingController.class})
public class GreetingControllerTest extends BaseTestForController {

    @Test
    public void greeting() throws Exception {
        ResultActions result = mvc.perform(get("/"));
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(content().string(containsString("Погнали!")));
    }
}
