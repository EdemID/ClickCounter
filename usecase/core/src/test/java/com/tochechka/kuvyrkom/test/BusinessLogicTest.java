package com.tochechka.kuvyrkom.test;

import com.tochechka.kuvyrkom.core.BusinessLogic;
import com.tochechka.kuvyrkom.model.Click;
import com.tochechka.kuvyrkom.persistence.repository.ClickRepository;
import com.tochechka.kuvyrkom.persistence.service.ClickServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BusinessLogic.class})
@EnableJpaRepositories(basePackages = {"com.tochechka.kuvyrkom.persistence"})
@DataJpaTest
public class BusinessLogicTest {

    @Autowired
    private BusinessLogic businessLogic;

    @MockBean
    private ClickServiceImpl clickService;

    @MockBean
    private ClickRepository clickRepository;

    @Test
    public void incrementClick() {
        long initialNumber = 0;
        Click click = new Click();
        click.setId(1L);
        click.setCount(initialNumber);
        when(clickService.findById(1L)).thenReturn(click);

        long finiteNumber = 10;
        while (initialNumber < finiteNumber) {
            businessLogic.incrementClick(1L);
            initialNumber++;
        }

        long numberAfterIncrement = businessLogic.showCount(1L);
        Assertions.assertEquals(finiteNumber, numberAfterIncrement, "Ожидалось увеличение на " + finiteNumber);
    }
}
