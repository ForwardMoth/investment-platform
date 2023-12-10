package com.example.repository;

import com.example.domain.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Long> {
    Boolean existsByTicker(String ticker);
}