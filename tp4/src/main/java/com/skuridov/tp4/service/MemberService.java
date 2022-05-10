package com.skuridov.tp4.service;

import com.skuridov.tp4.dto.Document.BookForm;
import com.skuridov.tp4.dto.Loan.LoanForm;
import com.skuridov.tp4.model.Document.Book;
import com.skuridov.tp4.model.Document.Document;
import com.skuridov.tp4.model.Loan.Loan;
import com.skuridov.tp4.model.User.Member;
import com.skuridov.tp4.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final BookRepository bookRepository;


    public List<BookForm> getBooksByTitle(String title){
        List<BookForm> booksDTO = new ArrayList<>();
        for(Book b : bookRepository.findAllByTitleContainingIgnoreCase(title)){
            booksDTO.add(new BookForm(b));
        }
        return booksDTO;
    }

    public List<BookForm> getBooksByAuthor(String author){
        List<BookForm> booksDTO = new ArrayList<>();
        for(Book b : bookRepository.findAllByAuthorIsLikeIgnoreCase(author)){
            booksDTO.add(new BookForm(b));
        }
        return booksDTO;
    }

    public List<BookForm> getBooksByGenre(String genre){
        List<BookForm> booksDTO = new ArrayList<>();
        for(Book b : bookRepository.findAllByGenre(genre)){
            booksDTO.add(new BookForm(b));
        }
        return booksDTO;
    }

    public List<BookForm> getBooksByYear(int year){
        List<BookForm> booksDTO = new ArrayList<>();
        for(Book b : bookRepository.findAllByPublicationYear(year)){
            booksDTO.add(new BookForm(b));
        }
        return booksDTO;
    }
}
