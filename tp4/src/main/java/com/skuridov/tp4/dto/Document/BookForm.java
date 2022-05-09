package com.skuridov.tp4.dto.Document;

import com.skuridov.tp4.model.Document.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.skuridov.tp4.model.Document.Book.BOOK_LOAN_LENGTH;

@Data
@NoArgsConstructor
public class BookForm extends DocumentForm {
    private String author;
    private String editor;
    private int pageAmount;
    private String genre;

    public BookForm(String id, String title, int publicationYear, String language, int nbCopies, String author, String editor, int pageAmount, String genre) {
        super(id, title, publicationYear, language, BOOK_LOAN_LENGTH, nbCopies);
        this.author = author;
        this.editor = editor;
        this.pageAmount = pageAmount;
        this.genre = genre;
    }

    public BookForm(Book book){
        this(Long.toString(book.getId()), book.getTitle(), book.getPublicationYear(), book.getLanguage(), book.getNbCopies(), book.getAuthor(), book.getEditor(), book.getPageAmount(), book.getGenre());
    }

    public Book toBook(){
        return new Book(this.getTitle(), this.getPublicationYear(), this.getLanguage(), this.getAuthor(), this.getEditor(), this.getPageAmount(), this.getGenre(), this.getNbCopies());
    }
}
