package com.skuridov.tp4.repository;

import com.skuridov.tp4.model.User.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberById(long id);
    @Query("SELECT m from Member m left join fetch m.loanList ll where m.id = :id")
    Optional<Member> findMemberByIdWithLoanList(long id);


}
