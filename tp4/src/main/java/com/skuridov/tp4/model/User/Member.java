package com.skuridov.tp4.model.User;

import com.skuridov.tp4.model.Fine.Fine;
import com.skuridov.tp4.model.Loan.Loan;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("MEMBER")
@Data
@NoArgsConstructor
public class Member extends User {

    @OneToMany(mappedBy = "borrower")
    @ToString.Exclude
    List<Loan> loanList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    List<Fine> fineList = new ArrayList<>();

    public Member(String firstName, String lastName, String address) {
        super(firstName, lastName, address);
    }

}
