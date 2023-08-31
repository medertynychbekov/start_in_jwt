package com.example.start_in_jwt.controller;

import com.example.start_in_jwt.model.dto.UserRequest;
import com.example.start_in_jwt.model.dto.UserResponse;
import com.example.start_in_jwt.service.impl.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @PostMapping
    public UserResponse save(@RequestBody UserRequest userRequest) {
        return userService.save(userRequest);
    }

    @GetMapping("{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @PutMapping("{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.update(id, userRequest);
    }

    @DeleteMapping("{id}")
    public UserResponse delete(@PathVariable Long id){
        return userService.delete(id);
    }

    @PostMapping("send-message")
    public String sendMessage(@RequestParam String message){
        return message;
    }

}
