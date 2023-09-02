package com.example.start_in_jwt.controller;

import com.example.start_in_jwt.config.jwt.JwtUtil;
import com.example.start_in_jwt.model.dto.LoginRequest;
import com.example.start_in_jwt.model.dto.LoginResponse;
import com.example.start_in_jwt.model.dto.UserRequest;
import com.example.start_in_jwt.model.dto.UserResponse;
import com.example.start_in_jwt.model.dto.mapper.LoginMapper;
import com.example.start_in_jwt.model.enitity.User;
import com.example.start_in_jwt.repository.UserRepository;
import com.example.start_in_jwt.service.impl.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {

    UserService userService;
    UserRepository userRepository;
    LoginMapper loginMapper;
    JwtUtil jwtUtil;
    UserDetailsService userDetailsService;

    @PostMapping("/sing-up")
    public UserResponse save(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @PostMapping("/sing-in")
    public LoginResponse singIn(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        User user = userRepository.findByName(token.getName());
        return loginMapper.mapToResponse(jwtUtil.generateToken(userDetailsService.loadUserByUsername("admin")), user.getRoles().toString());
    }
}
