package com.tochechka.kuvyrkom.test;

import com.tochechka.kuvyrkom.model.Click;
import com.tochechka.kuvyrkom.persistence.repository.ClickRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackages = "com.tochechka.kuvyrkom.persistence")
@EntityScan(basePackages = "com.tochechka.kuvyrkom.model")
@ComponentScan(basePackages = "com")
@ContextConfiguration(classes = {ClickRepository.class})
public class ClickRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ClickRepository repository;

    @Test
    public void incrementClickByTwoWithNativeQuery() {
        Click click = new Click();
        click.setCount(6L);
        entityManager.persist(click);

        repository.incrementClickByTwoWithNativeQuery(1L);

        Click updatedClick = repository.findById(1L).orElseThrow(() -> new EntityNotFoundException(" не найден!"));
        Assertions.assertEquals(8, updatedClick.getCount(), "Ожидалось увеличение на 2");
    }
}
