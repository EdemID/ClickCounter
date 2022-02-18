package com.tochechka.kuvyrkom.persistence.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ServiceJdbc {
    private final JdbcTemplate jdbcTemplate;

    public void incrementClickByThreeWithJdbcTemplate() {
        jdbcTemplate.update("UPDATE click SET count = count + 3 WHERE id = 1");
    }
}
