package com.skuridov.tp4.repository;

import com.skuridov.tp4.model.Document.Cd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CdRepository extends JpaRepository<Cd, Long> {
}
