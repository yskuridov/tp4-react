package com.skuridov.tp4.repository;

import com.skuridov.tp4.model.Fine.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FineRepository extends JpaRepository<Fine, Long> {
    List<Fine> findAllByMemberId(Long id);
}
