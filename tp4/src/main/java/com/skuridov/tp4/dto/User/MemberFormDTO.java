package com.skuridov.tp4.dto.User;


import com.skuridov.tp4.model.User.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberFormDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String address;

    public MemberFormDTO(String id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public MemberFormDTO(Member member){
        this(Long.toString(member.getId()), member.getFirstName(), member.getLastName(), member.getAddress());
    }

    public Member toMember(){
        return new Member(getFirstName(), getLastName(), getAddress());
    }

}
