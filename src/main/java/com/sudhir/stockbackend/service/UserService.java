package com.sudhir.stockbackend.service;

import com.sudhir.stockbackend.config.JwtService;
import com.sudhir.stockbackend.model.*;
import com.sudhir.stockbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public UserResponse createUser(UserRequest request) {
        String encoderPassword = passwordEncoder.encode(request.getPassword());
        request.setPassword(encoderPassword);
        UserModel user = UserMapper.toEntity(request);
        UserModel savedUser = repository.save(user);
        return UserMapper.toResponse(savedUser);
    }

    public ResponseEntity<String> loginUser(LoginRequest request){
        System.out.println("request "+request);
        var user = repository.findByEmail(request.getEmail());
        System.out.println("service user "+user);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        if (!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
        String token = jwtService.generateToken(user.get());
        System.out.println("token"+token);
        return ResponseEntity.ok(token);
    }
}
