package com.sudhir.stockbackend.service;

import com.sudhir.stockbackend.config.JwtService;
import com.sudhir.stockbackend.model.UserModel;
import com.sudhir.stockbackend.model.company.CompanyMapper;
import com.sudhir.stockbackend.model.company.CompanyModel;
import com.sudhir.stockbackend.model.company.CompanyRequest;
import com.sudhir.stockbackend.model.company.CompanyResponse;
import com.sudhir.stockbackend.repository.CompanyRepository;
import com.sudhir.stockbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository repository;
    @Autowired
    private JwtService jwt;
    @Autowired
    private UserRepository userRepo;

//    public CompanyResponse createCompany(CompanyRequest request,String token) {
//        Long userId =jwt.extractUserId(token);
//        CompanyModel company = CompanyMapper.toEntity(request,userId);
//        CompanyModel savedCompany = repository.save(company);
//        return CompanyMapper.toResponse(savedCompany);
//    }
      public CompanyResponse createCompany(CompanyRequest request, String email) {
          UserModel user = userRepo.findByEmail(email)
             .orElseThrow(() -> new RuntimeException("User not found for email: " + email));
          Long userId = user.getUserId();
          CompanyModel company = CompanyMapper.toEntity(request, userId);
          CompanyModel savedCompany = repository.save(company);
          return CompanyMapper.toResponse(savedCompany);
      }
}
