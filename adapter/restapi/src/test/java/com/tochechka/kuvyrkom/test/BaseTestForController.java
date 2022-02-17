package com.tochechka.kuvyrkom.test;

import com.tochechka.kuvyrkom.restapi.ClickController;
import com.tochechka.kuvyrkom.restapi.GreetingController;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ClickController.class, GreetingController.class})
@WebMvcTest({ClickController.class, GreetingController.class})
public abstract class BaseTestForController {

    @Autowired
    MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;
}
