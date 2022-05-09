package com.skuridov.tp4.model.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
@Data
@NoArgsConstructor
public class Dvd extends Document {
    private int durationInMinutes;
    private String category;
    private String mainActor;
    public static final int DVD_LOAN_LENGTH = 7; //days

    public Dvd(String title, int publicationYear, String language, int durationInMinutes, String category, String mainActor, int nbOfCopies) {
        super(title, publicationYear, language, nbOfCopies);
        this.durationInMinutes = durationInMinutes;
        this.category = category;
        this.mainActor = mainActor;
        this.setLoanLength(DVD_LOAN_LENGTH);
    }
}
