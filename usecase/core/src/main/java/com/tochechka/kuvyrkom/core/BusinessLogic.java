package com.tochechka.kuvyrkom.core;

import com.tochechka.kuvyrkom.model.Click;
import com.tochechka.kuvyrkom.persistence.service.ClickServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BusinessLogic {

    private ClickServiceImpl clickService;

    public Long incrementClick(Long id) {
        Click click = clickService.findById(id);
        Long count = click.getCount();
        Long currentCount = ++count;
        click.setCount(currentCount);
        clickService.save(click);
        return currentCount;
    }

    public Long showCount(Long id) {
        return clickService.findById(id).getCount();
    }

    public Long startOver(Long id) {
        Click click = clickService.findById(id);
        click.setCount(0L);
        return clickService.save(click).getCount();
    }

    public Long incrementClickByTwoWithNativeQuery(Long id) {
        return clickService.incrementClickByTwoWithNativeQuery(id).getCount();
    }
}
