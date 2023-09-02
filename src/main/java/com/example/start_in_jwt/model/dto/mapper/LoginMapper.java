package com.example.start_in_jwt.model.dto.mapper;

import com.example.start_in_jwt.model.dto.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public LoginResponse mapToResponse(String token, String roleName) {
        return LoginResponse.builder()
                .token(token)
                .roleName(roleName)
                .build();
    }
}
