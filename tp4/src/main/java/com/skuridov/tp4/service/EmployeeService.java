package com.skuridov.tp4.service;

import com.skuridov.tp4.dto.Document.BookForm;
import com.skuridov.tp4.dto.Document.CdForm;
import com.skuridov.tp4.dto.Document.DvdForm;
import com.skuridov.tp4.dto.User.MemberForm;
import com.skuridov.tp4.model.Document.Book;
import com.skuridov.tp4.model.Document.Cd;
import com.skuridov.tp4.model.Document.Dvd;
import com.skuridov.tp4.model.User.Member;
import com.skuridov.tp4.repository.BookRepository;
import com.skuridov.tp4.repository.DocumentRepository;
import com.skuridov.tp4.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeService {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private DocumentRepository documentRepository;

    public MemberForm createMember(Member member){
        memberRepository.save(member);
        return new MemberForm(member);
    }

    public BookForm createBook(Book book){
        bookRepository.save(book);
        return new BookForm(book);
    }

    public MemberForm getMember(Long id) throws Exception {
        Optional<Member> memberOpt = memberRepository.findMemberById(id);
        if(memberOpt.isEmpty()) throw new Exception("Member with id " + id + "doesn't exist");
        return new MemberForm(memberOpt.get());
    }

    public CdForm createCd(Cd cd){
        documentRepository.save(cd);
        return new CdForm(cd);
    }

    public DvdForm createDvd(Dvd dvd){
        documentRepository.save(dvd);
        return new DvdForm(dvd);
    }

}
