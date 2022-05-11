package com.skuridov.tp4.controller;

import com.skuridov.tp4.dto.Document.BookFormDTO;
import com.skuridov.tp4.dto.Document.CdFormDTO;
import com.skuridov.tp4.dto.Document.DvdFormDTO;
import com.skuridov.tp4.dto.Loan.LoanFormDTO;
import com.skuridov.tp4.dto.User.MemberFormDTO;
import com.skuridov.tp4.service.EmployeeService;
import com.skuridov.tp4.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class ReactController {
    private final EmployeeService employeeService;
    private final MemberService memberService;


    @GetMapping("/members")
    public List<MemberFormDTO> getAllMembers() {
        return employeeService.getMembers();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberFormDTO> getMember(@PathVariable Long id) throws Exception {
        return employeeService.getMember(id).map(memberForm -> ResponseEntity.status(HttpStatus.CREATED).body(memberForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<MemberFormDTO> updateMember(@RequestBody MemberFormDTO member, @PathVariable Long id) throws Exception {
        return employeeService.updateMember(member, id).map(memberForm -> ResponseEntity.status(HttpStatus.CREATED).body((memberForm))).orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/members")
    public ResponseEntity<MemberFormDTO> createMember(@RequestBody MemberFormDTO member){
        return employeeService.createMember(member.toMember()).map(memberForm -> ResponseEntity.status(HttpStatus.CREATED).body((memberForm))).orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/documents/books/author/{name}")
    public List<BookFormDTO> getBooksByAuthor(@PathVariable String name){
        return memberService.getBooksByAuthor(name);
    }

    @GetMapping("/documents/books/name/{name}")
    public List<BookFormDTO> getBooksByName(@PathVariable String name){
        return memberService.getBooksByTitle(name);
    }

    @GetMapping("/documents/books/genre/{genre}")
    public List<BookFormDTO> getBooksByGenre(@PathVariable String genre){
        return memberService.getBooksByGenre(genre);
    }

    @GetMapping("/documents/books/year/{year}")
    public List<BookFormDTO> getBooksByYear(@PathVariable int year){
        return memberService.getBooksByYear(year);
    }

    @PostMapping("/documents/dvds")
    public ResponseEntity<DvdFormDTO> createDvd(@RequestBody DvdFormDTO dvd){
        return employeeService.createDvd(dvd.toDvd()).map(dvdForm -> ResponseEntity.status(HttpStatus.CREATED).body(dvdForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/documents/cds")
    public ResponseEntity<CdFormDTO> createCd(@RequestBody CdFormDTO cd){
        return employeeService.createCd(cd.toCd()).map(cdForm -> ResponseEntity.status(HttpStatus.CREATED).body(cdForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/documents/books")
    public ResponseEntity<BookFormDTO> createBook(@RequestBody BookFormDTO book){
        return employeeService.createBook(book.toBook()).map(bookForm -> ResponseEntity.status(HttpStatus.CREATED).body(bookForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @GetMapping("/loans/{id}")
    public ResponseEntity<List<LoanFormDTO>> getMemberLoans(@PathVariable Long id) throws Exception{
        return employeeService.getLoans(id).map(loanForms -> ResponseEntity.status(HttpStatus.CREATED).body(loanForms))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PostMapping("/loans")
    public ResponseEntity<LoanFormDTO> createLoan(@RequestBody LoanFormDTO loan) throws Exception {
        return employeeService.loanDocument(Long.parseLong(loan.getMember()), Long.parseLong(loan.getId())).map(loanForm -> ResponseEntity.status(HttpStatus.CREATED).body(loanForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @PutMapping("/loans")
    public ResponseEntity<LoanFormDTO> returnDocument(@RequestBody LoanFormDTO loan) throws Exception {
        return employeeService.returnDocument(Long.parseLong(loan.getMember()), Long.parseLong(loan.getId())).map(loanForm -> ResponseEntity.status(HttpStatus.CREATED).body(loanForm))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
