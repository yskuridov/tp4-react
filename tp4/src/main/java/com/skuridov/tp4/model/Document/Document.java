package com.skuridov.tp4.model.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "document_type")
@Data
@NoArgsConstructor
public abstract class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private int publicationYear;
    private String language;
    private int loanLength;
    private int nbCopies;


    public Document(String title, int publicationYear, String language, int nbCopies) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.language = language;
        this.nbCopies = nbCopies;
    }
}

