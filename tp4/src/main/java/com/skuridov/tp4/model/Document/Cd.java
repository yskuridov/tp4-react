package com.skuridov.tp4.model.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CD")
@Data
@NoArgsConstructor
public class Cd extends Document {
    private String singer;
    private int numberOfTracks;
    private String genre;
    public static final int CD_LOAN_LENGTH = 14; //days

    public Cd(String title, int publicationYear, String language, String singer, int numberOfTracks, String genre, int nbOfCopies) {
        super(title, publicationYear, language, nbOfCopies);
        this.singer = singer;
        this.numberOfTracks = numberOfTracks;
        this.genre = genre;
        this.setLoanLength(CD_LOAN_LENGTH);
    }
}

