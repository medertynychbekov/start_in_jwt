package com.example.start_in_jwt.service.impl;

import com.example.start_in_jwt.exception.EntityNotFoundException;
import com.example.start_in_jwt.model.dto.UserRequest;
import com.example.start_in_jwt.model.dto.UserResponse;
import com.example.start_in_jwt.model.dto.mapper.UserMapper;
import com.example.start_in_jwt.model.enitity.User;
import com.example.start_in_jwt.repository.UserRepository;
import com.example.start_in_jwt.service.ServiceLayer;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserService implements ServiceLayer<UserRequest, UserResponse> {

    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    public UserResponse save(UserRequest userRequest) {
//        User user = userMapper.mapToEntity(userRequest);
//        userRepository.save(user);
//        UserResponse userResponse = userMapper.mapToResponse(user);
//        return userResponse;
        return userMapper.mapToResponse(userRepository.save(userMapper.mapToEntity(userRequest)));
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        User user = oneUserById(id);
        user.setName(userRequest.getName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setAge(userRequest.getAge());
        user.setCreatedDate(LocalDateTime.now());
        return userMapper.mapToResponse(userRepository.save(user));
    }

    @Override
    public UserResponse findById(Long id) {
        return userMapper.mapToResponse(oneUserById(id));
    }

    @Override
    public List<UserResponse> findAll() {
//        List<UserResponse> responses = new ArrayList<>();
//        for (User user : userRepository.findAll()) {
//            responses.add(userMapper.mapToResponse(user));
//        }
        return userRepository.findAll().stream()
                .map(userMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse delete(Long id) {
        User user = oneUserById(id);
        userRepository.delete(user);
        return userMapper.mapToResponse(user);
    }

    private User oneUserById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
