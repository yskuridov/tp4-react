package com.skuridov.tp4.model.Loan;

import com.skuridov.tp4.model.Document.Document;
import com.skuridov.tp4.model.User.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate dateBorrowed;
    private LocalDate dateDue;

    @ManyToOne
    @JoinColumn(name = "MEMBER_id")
    private Member borrower;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="DOCUMENTS_id")
    private Document document;

    public Loan(LocalDate dateBorrowed, LocalDate dateDue, Member borrower, Document document) {
        this.dateBorrowed = dateBorrowed;
        this.dateDue = dateDue;
        this.borrower = borrower;
        this.document = document;
    }
}