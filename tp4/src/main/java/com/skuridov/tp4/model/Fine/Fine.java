package com.skuridov.tp4.model.Fine;


import com.skuridov.tp4.model.User.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor

public class Fine {
    @Id
    @GeneratedValue
    private long id;
    public static final double FINE_AMOUNT = 0.25;
    private int nbOfDays;
    private final double amount = FINE_AMOUNT * nbOfDays;
    @ManyToOne
    @JoinColumn(name = "MEMBER_id")
    private Member member;

    public Fine(int nbOfDays, Member member){
        this.nbOfDays = nbOfDays;
        this.member = member;
    }

}
