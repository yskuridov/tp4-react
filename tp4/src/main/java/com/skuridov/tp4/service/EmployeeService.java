package com.skuridov.tp4.service;

import com.skuridov.tp4.dto.Document.BookForm;
import com.skuridov.tp4.dto.Document.CdForm;
import com.skuridov.tp4.dto.Document.DvdForm;
import com.skuridov.tp4.dto.Loan.LoanForm;
import com.skuridov.tp4.dto.User.MemberForm;
import com.skuridov.tp4.model.Document.Book;
import com.skuridov.tp4.model.Document.Cd;
import com.skuridov.tp4.model.Document.Document;
import com.skuridov.tp4.model.Document.Dvd;
import com.skuridov.tp4.model.Loan.Loan;
import com.skuridov.tp4.model.User.Member;
import com.skuridov.tp4.repository.BookRepository;
import com.skuridov.tp4.repository.DocumentRepository;
import com.skuridov.tp4.repository.LoanRepository;
import com.skuridov.tp4.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {
    private BookRepository bookRepository;
    private MemberRepository memberRepository;
    private DocumentRepository documentRepository;
    private LoanRepository loanRepository;

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

    public List<MemberForm> getMembers(){
        List<Member> members = memberRepository.findAll();
        List<MemberForm> membersForm = new ArrayList<>();
        for(Member m : members){
            membersForm.add(new MemberForm(m));
        }
        return membersForm;
    }

    public CdForm createCd(Cd cd){
        documentRepository.save(cd);
        return new CdForm(cd);
    }

    public DvdForm createDvd(Dvd dvd){
        documentRepository.save(dvd);
        return new DvdForm(dvd);
    }

    public LoanForm loanDocument(long memberId, long documentId) throws Exception {
        Member member = getMemberFromOptional(memberId);
        Document document = getDocumentFromOptional(documentId);
        Loan loan = new Loan(LocalDate.now(), LocalDate.now().plusDays(document.getLoanLength()), member, document);
        if(checkForAvailability(document)){
            document.setNbCopies(document.getNbCopies() - 1);
            member.getLoanList().add(loan);
            memberRepository.save(member);
            documentRepository.save(document);
            loanRepository.save(loan);
            return new LoanForm(loan);
        }
        else throw new Exception("Document can't be loaned");
    }

    public void returnDocument(long memberId, long documentId) throws Exception{
        Member member = getMemberFromOptional(memberId);
        Document document = getDocumentFromOptional(documentId);
        Loan loan = findLoan(member, document);
        member.getLoanList().remove(loan);
        document.setNbCopies(document.getNbCopies() + 1);
        memberRepository.save(member);
        documentRepository.save(document);
        loanRepository.delete(loan);
    }


    public List<LoanForm> getLoans(long id) throws Exception {
        Member member = getMemberFromOptional(id);
        List<LoanForm> loanFormList = new ArrayList<>();
        for(Loan l : member.getLoanList()){
            loanFormList.add(new LoanForm(l));
        }
        return loanFormList;
    }


    private Loan findLoan(Member member, Document document) throws Exception {
        for(Loan l : member.getLoanList()){
            if(l.getDocument().equals(document)){
                return l;
            }
        }
        throw new Exception("The document wasn't loaned by that member");
    }


    private Member getMemberFromOptional(long id) throws Exception{
        Optional<Member> memberOpt = memberRepository.findMemberByIdWithFineList(id);
        if(memberOpt.isEmpty()){
            throw new Exception("Member entity not found");
        }
        Member member = memberOpt.get();
        member.setLoanList(memberRepository.findMemberByIdWithLoanList(id).get().getLoanList());
        return member;
    }

    private Document getDocumentFromOptional(long id) throws Exception{
        Optional<Document> documentOpt = documentRepository.findById(id);
        if(documentOpt.isEmpty()){
            throw new Exception("Document entity not found");
        }
        Document document = documentOpt.get();
        return document;
    }

    private boolean checkForAvailability(Document document){
        return document.getNbCopies() > 0;
    }

}
