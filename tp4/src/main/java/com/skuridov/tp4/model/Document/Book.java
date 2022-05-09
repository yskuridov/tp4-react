package com.skuridov.tp4.model.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
@Data
@NoArgsConstructor
public class Book extends Document {
    private String author;
    private String editor;
    private int pageAmount;
    private String genre;
    public static final int BOOK_LOAN_LENGTH = 21; //days

    public Book(String title, int publicationYear, String language, String author, String editor, int pageAmount, String genre, int nbOfCopies) {
        super(title, publicationYear, language, nbOfCopies);
        this.author = author;
        this.editor = editor;
        this.pageAmount = pageAmount;
        this.genre = genre;
        this.setLoanLength(BOOK_LOAN_LENGTH);
    }

}
