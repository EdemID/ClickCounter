package com.tochechka.kuvyrkom.persistence.service;

import com.tochechka.kuvyrkom.model.Click;
import com.tochechka.kuvyrkom.persistence.repository.ClickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class ClickServiceImpl {

    private final ClickRepository clickRepository;

    public Click findById(Long id) {
        return clickRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Клик с id=" + id + " не найден!"));
    }

    public Click save(Click click) {
        return clickRepository.save(click);
    }
}
