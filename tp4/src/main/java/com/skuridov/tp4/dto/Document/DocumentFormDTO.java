package com.skuridov.tp4.dto.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class DocumentFormDTO {
    private String id;
    private String title;
    private int publicationYear;
    private String language;
    private int loanLength;
    private int nbCopies;

    public DocumentFormDTO(String id, String title, int publicationYear, String language, int loanLength, int nbCopies){
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.language = language;
        this.loanLength = loanLength;
        this.nbCopies = nbCopies;
    }

}
