package com.security.project.controller;

import org.springframework.security.access.annotation.Secured;
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
    @PreAuthorize("hasAuthority('ROLE_USER')") //in preauthorize check this statement before execute method
    @GetMapping("/my-account")
    public String getAccountDetails(){
        return "this is for acc details";
    }
}
