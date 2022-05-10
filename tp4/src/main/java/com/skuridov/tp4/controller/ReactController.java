package com.skuridov.tp4.controller;

import com.skuridov.tp4.dto.Document.DocumentForm;
import com.skuridov.tp4.dto.Loan.LoanForm;
import com.skuridov.tp4.dto.User.MemberForm;
import com.skuridov.tp4.model.Document.Document;
import com.skuridov.tp4.model.Loan.Loan;
import com.skuridov.tp4.service.EmployeeService;
import com.skuridov.tp4.service.MemberService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<MemberForm>> getAllMembers() {

    }

    @GetMapping("/members/{id}")
    public ResponseEntity<MemberForm> getMember(@PathVariable Long id){

    }

    @PutMapping("/members/{id}")
    public ResponseEntity<MemberForm> updateMember(@RequestBody MemberForm member, @PathVariable Long id){

    }

    @PostMapping("/members")
    public ResponseEntity<MemberForm> createMember(@RequestBody MemberForm member){

    }

    @GetMapping("/documents")
    public ResponseEntity<List<Document>> getAllDocuments(){

    }

    @PostMapping("/documents")
    public ResponseEntity<Document> createDocument(@RequestBody DocumentForm document){

    }

    @GetMapping("/loans/{id}")
    public ResponseEntity<List<Loan>> getMemberLoans(@PathVariable Long id){

    }

    @PostMapping("/loans")
    public ResponseEntity<LoanForm> createLoan(@RequestBody LoanForm loan){

    }

    @PutMapping("/loans")
    public ResponseEntity<LoanForm> returnDocument(@RequestBody LoanForm loan){

    }
}
