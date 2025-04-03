package com.security.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    // generator ="native" this tells Hibernate to
    // choose the best strategy based on the database.
    //eg:mysql--> auto increment
    //note: if you directly use like mysql you can only want (strategy =GenerationType.IDENTITY) is enough.
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String role; // note that when type variable like Role it not correctly works because json property handle only like role

}


