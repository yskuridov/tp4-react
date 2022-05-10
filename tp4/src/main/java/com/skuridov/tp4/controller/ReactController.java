package com.skuridov.tp4.controller;

import com.skuridov.tp4.dto.Document.BookForm;
import com.skuridov.tp4.dto.Document.CdForm;
import com.skuridov.tp4.dto.Document.DocumentForm;
import com.skuridov.tp4.dto.Document.DvdForm;
import com.skuridov.tp4.dto.Loan.LoanForm;
import com.skuridov.tp4.dto.User.MemberForm;
import com.skuridov.tp4.model.Document.Book;
import com.skuridov.tp4.model.Document.Document;
import com.skuridov.tp4.model.Loan.Loan;
import com.skuridov.tp4.service.EmployeeService;
import com.skuridov.tp4.service.MemberService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class ReactController {
    private EmployeeService employeeService;
    private MemberService memberService;

    public ReactController(EmployeeService es, MemberService ms){
        this.employeeService = es;
        this.memberService = ms;
    }

    @GetMapping("/members")
    public List<MemberForm> getAllMembers() {
        return employeeService.getMembers();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberForm> getMember(@PathVariable Long id) throws Exception {
        return employeeService.getMember(id).map(memberForm -> ResponseEntity.status(HttpStatus.CREATED).body(memberForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<MemberForm> updateMember(@RequestBody MemberForm member, @PathVariable Long id){
        return employeeService.createMember(member.toMember()).map(memberForm -> ResponseEntity.status(HttpStatus.CREATED).body((memberForm))).orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/members")
    public ResponseEntity<MemberForm> createMember(@RequestBody MemberForm member){
        return employeeService.createMember(member.toMember()).map(memberForm -> ResponseEntity.status(HttpStatus.CREATED).body((memberForm))).orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/documents/books/author/{name}")
    public List<BookForm> getBooksByAuthor(@PathVariable String name){
        return memberService.getBooksByAuthor(name);
    }

    @GetMapping("/documents/books/name/{name}")
    public List<BookForm> getBooksByName(@PathVariable String name){
        return memberService.getBooksByTitle(name);
    }

    @GetMapping("/documents/books/genre/{genre}")
    public List<BookForm> getBooksByGenre(@PathVariable String genre){
        return memberService.getBooksByGenre(genre);
    }

    @GetMapping("/documents/books/year/{year}")
    public List<BookForm> getBooksByYear(@PathVariable int year){
        return memberService.getBooksByYear(year);
    }

    @PostMapping("/documents/dvds")
    public ResponseEntity<DvdForm> createDvd(@RequestBody DvdForm dvd){
        return employeeService.createDvd(dvd.toDvd()).map(dvdForm -> ResponseEntity.status(HttpStatus.CREATED).body(dvdForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/documents/cds")
    public ResponseEntity<CdForm> createCd(@RequestBody CdForm cd){
        return employeeService.createCd(cd.toCd()).map(cdForm -> ResponseEntity.status(HttpStatus.CREATED).body(cdForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/documents/books")
    public ResponseEntity<BookForm> createBook(@RequestBody BookForm book){
        return employeeService.createBook(book.toBook()).map(bookForm -> ResponseEntity.status(HttpStatus.CREATED).body(bookForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/loans/{id}")
    public ResponseEntity<List<LoanForm>> getMemberLoans(@PathVariable Long id) throws Exception{
        return employeeService.getLoans(id).map(loanForms -> ResponseEntity.status(HttpStatus.CREATED).body(loanForms))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/loans")
    public ResponseEntity<LoanForm> createLoan(@RequestBody LoanForm loan) throws Exception {
        return employeeService.loanDocument(Long.parseLong(loan.getMember()), Long.parseLong(loan.getId())).map(loanForm -> ResponseEntity.status(HttpStatus.CREATED).body(loanForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/loans")
    public ResponseEntity<LoanForm> returnDocument(@RequestBody LoanForm loan) throws Exception {
        return employeeService.returnDocument(Long.parseLong(loan.getMember()), Long.parseLong(loan.getId())).map(loanForm -> ResponseEntity.status(HttpStatus.CREATED).body(loanForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
