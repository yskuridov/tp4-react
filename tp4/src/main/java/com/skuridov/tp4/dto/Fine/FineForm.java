package com.skuridov.tp4.dto.Fine;

import com.skuridov.tp4.model.Fine.Fine;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FineForm {
    private String id;
    private final double FINE_AMOUNT = Fine.FINE_AMOUNT;
    private int nbOfDays;
    private final double amount = FINE_AMOUNT * nbOfDays;
    private String member;

    public FineForm(String id, int nbOfDays, String member) {
        this.id = id;
        this.nbOfDays = nbOfDays;
        this.member = member;
    }

    public FineForm(Fine fine){
        this(Long.toString(fine.getId()), fine.getNbOfDays(), Long.toString(fine.getMember().getId()));
    }

}
