package com.security.project.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/account")
@CrossOrigin


public class AccountController {
//    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasAuthority('ROLE_USER')") //in preauthorize check this statement before execute method
    @PostAuthorize("hasAuthority('ROLE_USER')") //in postAuthorize it first going though method executed and  before retun statment
    //it check the authorize.so that why we can see print in method for unauthorized users when accessing this end point
    @GetMapping("/my-account")
    public String getAccountDetails(){
        System.out.println("inside the method");
        return "this is for acc details";
    }
}
