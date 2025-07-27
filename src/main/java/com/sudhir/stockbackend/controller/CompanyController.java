package com.sudhir.stockbackend.controller;

import com.sudhir.stockbackend.model.company.CompanyLoginRequest;
import com.sudhir.stockbackend.model.company.CompanyRequest;
import com.sudhir.stockbackend.model.company.CompanyResponse;
import com.sudhir.stockbackend.service.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @PostMapping("/register")
    public ResponseEntity<CompanyResponse> createCompany(@Valid @RequestBody CompanyRequest request) {
        //System.out.println(request);
        CompanyResponse response = service.createCompany(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCompany(@Valid @RequestBody CompanyLoginRequest request){
        System.out.println("Request in Controller "+ request);
        return service.companyLogin(request);
    }
}
