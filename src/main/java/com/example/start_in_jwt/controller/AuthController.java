package com.example.start_in_jwt.controller;

import com.example.start_in_jwt.model.dto.UserRequest;
import com.example.start_in_jwt.model.dto.UserResponse;
import com.example.start_in_jwt.service.impl.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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

    @PostMapping("sing-in")
    public UserResponse save(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

    public
}
