package com.skuridov.tp4.model.User;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue("EMPLOYEE")
@Data
@NoArgsConstructor
public class Employee extends User {
    public Employee(String firstName, String lastName, String address) {
        super(firstName, lastName, address);
    }
}