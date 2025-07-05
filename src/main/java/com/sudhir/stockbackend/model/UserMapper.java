package com.sudhir.stockbackend.model;

public class UserMapper {

    public static UserModel toEntity(UserRequest request) {
        UserModel user = new UserModel();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // encode before saving!
        user.setFullName(request.getFullName());
        user.setRole(request.getRole());
        return user;
    }

    public static UserResponse toResponse(UserModel user) {
        UserResponse response = new UserResponse();
        response.setId(user.getUserId());
        response.setEmail(user.getEmail());
        response.setFullName(user.getFullName());
        return response;
    }

}
