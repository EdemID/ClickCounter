package com.tochechka.kuvyrkom.test;

import com.tochechka.kuvyrkom.core.BusinessLogic;
import com.tochechka.kuvyrkom.restapi.ClickController;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = {ClickController.class})
@WebMvcTest({ClickController.class})
public class ClickControllerTest extends BaseTestForController {

    @MockBean
    private BusinessLogic businessLogic;

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
