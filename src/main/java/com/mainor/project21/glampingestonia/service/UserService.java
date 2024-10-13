package com.mainor.project21.glampingestonia.service;

import com.mainor.project21.glampingestonia.mapper.UserMapper;
import com.mainor.project21.glampingestonia.model.User;
import com.mainor.project21.glampingestonia.repository.UserRepository;
import com.mainor.project21.glampingestonia.dto.CreateUserRequest;
import com.mainor.project21.glampingestonia.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public UserDto create(CreateUserRequest createUserRequest) throws Exception {
        User user = UserMapper.toEntity(createUserRequest);
        return UserMapper.toDto(userRepository.save(user));
    }

    public UserDto findById(String id) throws Exception {
        User user = requireUser(id);
        return UserMapper.toDto(user);
    }

    private User requireUser(String id) throws Exception {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("user not found"));
    }
}
