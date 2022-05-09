package com.skuridov.tp4.repository;

import com.skuridov.tp4.model.Document.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByAuthorIsLikeIgnoreCase(String author);
    List<Book> findAllByPublicationYear(int year);
    List<Book> findAllByGenre(String genre);
    List<Book> findAllByTitleContainingIgnoreCase(String title);
}
