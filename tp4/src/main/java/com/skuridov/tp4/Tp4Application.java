package com.skuridov.tp4;

import com.skuridov.tp4.model.Document.Book;
import com.skuridov.tp4.model.Document.Document;
import com.skuridov.tp4.model.User.Member;
import com.skuridov.tp4.service.EmployeeService;
import com.skuridov.tp4.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Tp4Application implements CommandLineRunner {

    private final EmployeeService es;
    private final MemberService ms;

    public static void main(String[] args) {

        SpringApplication.run(Tp4Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception
    {
        es.createMember(new Member("Yegor", "Skuridov", "18224"));
        es.createMember(new Member("asfqwf", "Skuridov", "182242"));
        es.createBook(new Book("22bsb", 2002, "so22", "auteur", "editeur", 2002, "coca", 4));

    }

}
