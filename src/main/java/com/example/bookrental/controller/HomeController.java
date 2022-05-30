package com.example.bookrental.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
/*
@RequestMapping(value = "/home")
*/
@RequestMapping(value = "/home")
public class HomeController {
/*    @RequestMapping(value = "/home")*/
    @GetMapping
    public RedirectView redirectToHome() {
        UserDetails principal = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Collection<? extends GrantedAuthority> role;
        role = principal.getAuthorities();

        if (role.toString().equals("[ROLE_ADMIN]")){
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:8080/admin");
            return redirectView;
        } else if (role.toString().equals("[ROLE_EMPLOYEE]")){
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:8080/employee");
            return redirectView;
        } else {
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:8080/user");
            return redirectView;
        }
    }
}