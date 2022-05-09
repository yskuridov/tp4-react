package com.skuridov.tp4.dto.Loan;

import com.skuridov.tp4.model.Loan.Loan;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoanForm {
    private String id;
    private String dateBorrowed;
    private String dateDue;
    private String member;
    private String document;

    public LoanForm(String id, String dateBorrowed, String dateDue, String member, String document) {
        this.id = id;
        this.dateBorrowed = dateBorrowed;
        this.dateDue = dateDue;
        this.member = member;
        this.document = document;
    }

    public LoanForm(Loan loan){
        this(Long.toString(loan.getId()), loan.getDateBorrowed().toString(), loan.getDateDue().toString(), Long.toString(loan.getBorrower().getId()), Long.toString(loan.getDocument().getId()));
    }

}

