package com.sudhir.stockbackend.controller;

import com.sudhir.stockbackend.model.company.CompanyRequest;
import com.sudhir.stockbackend.model.company.CompanyResponse;
import com.sudhir.stockbackend.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping("/register")
    public ResponseEntity<CompanyResponse> createCompany(@RequestBody @Valid CompanyRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        var company = service.createCompany(request, email);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

}
