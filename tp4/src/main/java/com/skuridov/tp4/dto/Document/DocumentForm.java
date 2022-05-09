package com.skuridov.tp4.dto.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public abstract class DocumentForm {
    private String id;
    private String title;
    private int publicationYear;
    private String language;
    private int loanLength;
    private int nbCopies;

    public DocumentForm(String id, String title, int publicationYear, String language, int loanLength, int nbCopies){
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.language = language;
        this.loanLength = loanLength;
        this.nbCopies = nbCopies;
    }

}
