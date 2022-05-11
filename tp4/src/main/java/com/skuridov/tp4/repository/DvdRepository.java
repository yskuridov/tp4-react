package com.skuridov.tp4.repository;

import com.skuridov.tp4.model.Document.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DvdRepository extends JpaRepository<Dvd, Long> {
}
