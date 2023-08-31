package com.example.start_in_jwt.model.dto.mapper;

import com.example.start_in_jwt.model.dto.UserRequest;
import com.example.start_in_jwt.model.dto.UserResponse;
import com.example.start_in_jwt.model.enitity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    public User mapToEntityWithoutBuilder(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setAge(userRequest.getAge());
        return user;
    }

    public User mapToEntity(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .age(userRequest.getAge())
                .createdDate(LocalDateTime.now())
                .build();
    }

    public UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .age(user.getAge())
                .createdDate(user.getCreatedDate())
                .build();
    }

}
