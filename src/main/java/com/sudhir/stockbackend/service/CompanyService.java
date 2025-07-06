package com.sudhir.stockbackend.service;

import com.sudhir.stockbackend.config.JwtService;
import com.sudhir.stockbackend.model.UserModel;
import com.sudhir.stockbackend.model.company.CompanyMapper;
import com.sudhir.stockbackend.model.company.CompanyModel;
import com.sudhir.stockbackend.model.company.CompanyRequest;
import com.sudhir.stockbackend.model.company.CompanyResponse;
import com.sudhir.stockbackend.repository.CompanyRepository;
import com.sudhir.stockbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CompanyService {
    private final CompanyRepository repository;
    private final UserRepository userRepository;

    public CompanyResponse createCompany(CompanyRequest request) {
        // get email from SecurityContext
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found for email: " + email));

        // map request to entity
        CompanyModel company = CompanyMapper.toEntity(request);
        // set user
        company.setUserId(user);

        CompanyModel savedCompany = repository.save(company);
        return CompanyMapper.toResponse(savedCompany);
    }
}
