package com.sudhir.stockbackend.model.user;

public class UserMapper {

    public static UserModel toEntity(UserRequest request) {
        UserModel user = new UserModel();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFullName(request.getFullName());
        user.setRole(request.getRole());
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

}
