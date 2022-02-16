package com.tochechka.kuvyrkom.persistence.repository;

import com.tochechka.kuvyrkom.model.Click;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClickRepository extends JpaRepository<Click, Long> {
}
