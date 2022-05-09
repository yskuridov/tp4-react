package com.skuridov.tp4.repository;

import com.skuridov.tp4.model.Loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findAllByBorrowerId(long id);
}
