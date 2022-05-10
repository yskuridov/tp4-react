package com.skuridov.tp4.dto.Document;

import com.skuridov.tp4.model.Document.Cd;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.skuridov.tp4.model.Document.Cd.CD_LOAN_LENGTH;

@Data
@NoArgsConstructor
public class CdFormDTO extends DocumentFormDTO {
    private String singer;
    private int nbOfTracks;
    private String genre;

    public CdFormDTO(String id, String title, int publicationYear, String language, String singer, int nbOfTracks, String genre, int nbCopies) {
        super(id, title, publicationYear, language, CD_LOAN_LENGTH, nbCopies);
        this.singer = singer;
        this.nbOfTracks = nbOfTracks;
        this.genre = genre;
    }

    public CdFormDTO(Cd cd){
        this(Long.toString(cd.getId()), cd.getTitle(), cd.getPublicationYear(), cd.getLanguage(), cd.getSinger(), cd.getNumberOfTracks(), cd.getGenre(), cd.getNbCopies());
    }

    public Cd toCd(){
        return new Cd(getTitle(), getPublicationYear(), getLanguage(), getSinger(), getNbOfTracks(), getGenre(), getNbCopies());
    }
}
