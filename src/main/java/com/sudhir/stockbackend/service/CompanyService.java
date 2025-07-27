package com.sudhir.stockbackend.service;

import com.sudhir.stockbackend.config.JwtService;
import com.sudhir.stockbackend.model.company.*;
import com.sudhir.stockbackend.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public CompanyResponse createCompany(CompanyRequest request) {
        String encoderPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encoderPassword);
        CompanyModel companyModel = CompanyMapper.toEntity(request);
        CompanyModel saved = repository.save(companyModel);
        return CompanyMapper.toResponse(saved);
    }

    public ResponseEntity<String> companyLogin(CompanyLoginRequest request) {
        System.out.println("Request in login "+ request);
        var company = repository.findByCompanyEmail(request.getCompanyEmail());
        if (company.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        if (!passwordEncoder.matches(request.getPassword(), company.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        String token = jwtService.generateTokenBYCompany(company.get());
        System.out.println("token"+token);
        return ResponseEntity.ok(token);
    }
}
