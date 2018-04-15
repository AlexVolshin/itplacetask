package com.itplace.volshin.summary.repository;

import com.itplace.volshin.summary.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary, Long> {

    Summary findSummaryById(Long id);

    void deleteById(Long id);

}
