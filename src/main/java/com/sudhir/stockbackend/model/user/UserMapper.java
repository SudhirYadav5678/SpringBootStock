package com.sudhir.stockbackend.model.user;

import java.math.BigDecimal;
import java.util.Date;

public class UserMapper {

    public static UserModel toEntity(UserRequest request) {
        UserModel user = new UserModel();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFullName(request.getFullName());
        user.setRole(request.getRole());
        user.setEnabled(request.isEnabled());
        return user;
    }

    public static UserResponse toResponse(UserModel user) {
        UserResponse response = new UserResponse();
        System.out.println("user Response "+user);
        response.setId(user.getUserId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setFullName(user.getFullName());
        return response;
    }

    public static void updateAccountFields(UserModel user, UserAccountRequest request) {
        user.setAccountBalance(request.getAccountBalance());
        user.setAccountNumber(request.getAccountNumber());
        user.setBankName(request.getBankName());
        user.setIfscCode(request.getIfscCode());
        user.setUpiId(request.getUpiId());
    }

    public static UserAccountResponse toAccountResponse(UserModel request){
        return UserAccountResponse.builder()
                .userId(request.getUserId())
                .username(request.getUsername())
                .fullName(request.getFullName())
                .email(request.getEmail())
                .accountBalance(request.getAccountBalance())
                .accountNumber(request.getAccountNumber())
                .bankName(request.getBankName())
                .ifscCode(request.getIfscCode())
                .upiId(request.getUpiId())
                .build();
    }
}
