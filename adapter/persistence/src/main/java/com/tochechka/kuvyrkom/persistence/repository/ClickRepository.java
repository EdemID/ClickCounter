package com.tochechka.kuvyrkom.persistence.repository;

import com.tochechka.kuvyrkom.model.Click;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClickRepository extends JpaRepository<Click, Long> {
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE click SET count = count + 2 WHERE id = :id", nativeQuery = true)
    void incrementClickByTwoWithNativeQuery(Long id);
}
