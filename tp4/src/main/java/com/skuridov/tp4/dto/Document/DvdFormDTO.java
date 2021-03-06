package com.skuridov.tp4.dto.Document;

import com.skuridov.tp4.model.Document.Dvd;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.skuridov.tp4.model.Document.Dvd.DVD_LOAN_LENGTH;

@Data
@NoArgsConstructor
public class DvdFormDTO extends DocumentFormDTO {
    private int duration;
    private String category;
    private String mainActor;

    public DvdFormDTO(String id, String title, int publicationYear, String language, int duration, String category, String mainActor, int nbCopies) {
        super(id, title, publicationYear, language, DVD_LOAN_LENGTH, nbCopies);
        this.duration = duration;
        this.category = category;
        this.mainActor = mainActor;
    }

    public DvdFormDTO(Dvd dvd){
        this(Long.toString(dvd.getId()), dvd.getTitle(), dvd.getPublicationYear(), dvd.getLanguage(), dvd.getDurationInMinutes(), dvd.getGenre(), dvd.getMainActor(), dvd.getNbCopies());
    }

    public Dvd toDvd(){
        return new Dvd(getTitle(), getPublicationYear(), getLanguage(), getDuration(), getCategory(), getMainActor(), getNbCopies());
    }
}
