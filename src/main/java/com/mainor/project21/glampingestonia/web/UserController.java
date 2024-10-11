package com.mainor.project21.glampingestonia.web;

import com.mainor.project21.glampingestonia.dto.CreateUserRequest;
import com.mainor.project21.glampingestonia.dto.UserDto;
import com.mainor.project21.glampingestonia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto create(@RequestBody CreateUserRequest request) throws Exception {
        return userService.create(request);
    }

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable String id){
        return userService.findById(id);
    }

}
