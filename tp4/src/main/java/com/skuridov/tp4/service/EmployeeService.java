package com.skuridov.tp4.service;

import com.skuridov.tp4.dto.Document.BookForm;
import com.skuridov.tp4.dto.User.MemberForm;
import com.skuridov.tp4.model.Document.Book;
import com.skuridov.tp4.model.User.Member;
import com.skuridov.tp3.tp3spring.repository.*;
import com.skuridov.tp4.repository.BookRepository;
import com.skuridov.tp4.repository.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;

    public MemberForm createMember(Member member){
        memberRepository.save(member);
        return new MemberForm(member);
    }

    public BookForm createBook(Book book){
        bookRepository.save(book);
        return new BookForm(book);
    }


}
