package com.security.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @GeneratedValue(strategy =GenerationType.AUTO,generator ="native") // generator ="native" this tells Hibernate to
    // choose the best strategy based on the database.
    //eg:mysql--> auto increment
    //note: if you directly use like mysql you can only want (strategy =GenerationType.IDENTITY) is enough.
    private int id;
    private String email;
    private String password;
    private String Role;
}
