package com.skuridov.tp4.service;

import com.skuridov.tp4.dto.Document.BookFormDTO;
import com.skuridov.tp4.model.Document.Book;
import com.skuridov.tp4.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final BookRepository bookRepository;


    public List<BookFormDTO> getBooksByTitle(String title){
        List<BookFormDTO> booksDTO = new ArrayList<>();
        for(Book b : bookRepository.findAllByTitleContainingIgnoreCase(title)){
            booksDTO.add(new BookFormDTO(b));
        }
        return booksDTO;
    }

    public List<BookFormDTO> getBooksByAuthor(String author){
        List<BookFormDTO> booksDTO = new ArrayList<>();
        for(Book b : bookRepository.findAllByAuthorIsLikeIgnoreCase(author)){
            booksDTO.add(new BookFormDTO(b));
        }
        return booksDTO;
    }

    public List<BookFormDTO> getBooksByGenre(String genre){
        List<BookFormDTO> booksDTO = new ArrayList<>();
        for(Book b : bookRepository.findAllByGenre(genre)){
            booksDTO.add(new BookFormDTO(b));
        }
        return booksDTO;
    }

    public List<BookFormDTO> getBooksByYear(int year){
        List<BookFormDTO> booksDTO = new ArrayList<>();
        for(Book b : bookRepository.findAllByPublicationYear(year)){
            booksDTO.add(new BookFormDTO(b));
        }
        return booksDTO;
    }
}
