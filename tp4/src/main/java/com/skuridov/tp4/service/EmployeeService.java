package com.skuridov.tp4.service;

import com.skuridov.tp4.dto.Document.BookFormDTO;
import com.skuridov.tp4.dto.Document.CdFormDTO;
import com.skuridov.tp4.dto.Document.DocumentFormDTO;
import com.skuridov.tp4.dto.Document.DvdFormDTO;
import com.skuridov.tp4.dto.Loan.LoanFormDTO;
import com.skuridov.tp4.dto.User.MemberFormDTO;
import com.skuridov.tp4.model.Document.Book;
import com.skuridov.tp4.model.Document.Cd;
import com.skuridov.tp4.model.Document.Document;
import com.skuridov.tp4.model.Document.Dvd;
import com.skuridov.tp4.model.Loan.Loan;
import com.skuridov.tp4.model.User.Member;
import com.skuridov.tp4.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final DocumentRepository documentRepository;
    private final LoanRepository loanRepository;
    private final CdRepository cdRepository;
    private final DvdRepository dvdRepository;


    public List<DocumentFormDTO> getDocuments(){
        List<DocumentFormDTO> documentFormDTOS = new ArrayList<>();
        documentFormDTOS.addAll(getAllBooks());
        documentFormDTOS.addAll(getAllCds());
        documentFormDTOS.addAll(getAllDvds());
        return documentFormDTOS;
    }

    private List<CdFormDTO> getAllCds(){
        List<Cd> cds = cdRepository.findAll();
        List<CdFormDTO> cdFormDTOS = new ArrayList<>();
        for(Cd cd : cds) cdFormDTOS.add(new CdFormDTO(cd));
        return cdFormDTOS;
    }

    private List<DvdFormDTO> getAllDvds(){
        List<Dvd> dvds = dvdRepository.findAll();
        List<DvdFormDTO> dvdFormDTOS = new ArrayList<>();
        for(Dvd dvd : dvds) dvdFormDTOS.add(new DvdFormDTO(dvd));
        return dvdFormDTOS;
    }

    private List<BookFormDTO> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        List<BookFormDTO> bookFormDTOS = new ArrayList<>();
        for(Book book : books) bookFormDTOS.add(new BookFormDTO(book));
        return bookFormDTOS;
    }
    public Optional<MemberFormDTO> createMember(Member member){
        memberRepository.save(member);
        return Optional.of(new MemberFormDTO(member));
    }

    public Optional<BookFormDTO> createBook(Book book){
        bookRepository.save(book);
        return Optional.of(new BookFormDTO(book));
    }

    public Optional<MemberFormDTO> getMember(Long id) throws Exception {
        Optional<Member> memberOpt = memberRepository.findMemberById(id);
        if(memberOpt.isEmpty()) throw new Exception("Member with id " + id + "doesn't exist");
        return Optional.of(new MemberFormDTO(memberOpt.get()));
    }

    public List<MemberFormDTO> getMembers(){
        List<Member> members = memberRepository.findAll();
        List<MemberFormDTO> membersForm = new ArrayList<>();
        for(Member m : members){
            membersForm.add(new MemberFormDTO(m));
        }
        return membersForm;
    }

    public Optional<CdFormDTO> createCd(Cd cd){
        documentRepository.save(cd);
        return Optional.of(new CdFormDTO(cd));
    }

    public Optional<DvdFormDTO> createDvd(Dvd dvd){
        documentRepository.save(dvd);
        return Optional.of(new DvdFormDTO(dvd));
    }

    public Optional<MemberFormDTO> updateMember(MemberFormDTO newMember, long id) throws Exception {
        Member member = getMemberFromOptional(id);
        List<Loan> loanList = member.getLoanList();
        member = newMember.toMember();
        member.setLoanList(loanList);
        memberRepository.save(member);
        return Optional.of(new MemberFormDTO(member));
    }

    public Optional<LoanFormDTO> loanDocument(long memberId, long documentId) throws Exception {
        Member member = getMemberFromOptional(memberId);
        Document document = getDocumentFromOptional(documentId);
        Loan loan = new Loan(LocalDate.now(), LocalDate.now().plusDays(document.getLoanLength()), member, document);
        if(checkForAvailability(document)){
            document.setNbCopies(document.getNbCopies() - 1);
            member.getLoanList().add(loan);
            memberRepository.save(member);
            documentRepository.save(document);
            loanRepository.save(loan);
            return Optional.of(new LoanFormDTO(loan));
        }
        else throw new Exception("Document can't be loaned");
    }

    public Optional<LoanFormDTO> returnDocument(long memberId, long documentId) throws Exception{
        Member member = getMemberFromOptional(memberId);
        Document document = getDocumentFromOptional(documentId);
        Loan loan = findLoan(member, document);
        member.getLoanList().remove(loan);
        document.setNbCopies(document.getNbCopies() + 1);
        memberRepository.save(member);
        documentRepository.save(document);
        loanRepository.delete(loan);
        return Optional.of(new LoanFormDTO(loan));
    }


    public Optional<List<LoanFormDTO>> getLoans(long id) throws Exception {
        Member member = getMemberFromOptional(id);
        List<LoanFormDTO> loanFormList = new ArrayList<>();
        for(Loan l : member.getLoanList()){
            loanFormList.add(new LoanFormDTO(l));
        }
        return Optional.of(loanFormList);
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
        Optional<Member> memberOpt = memberRepository.findMemberByIdWithLoanList(id);
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
