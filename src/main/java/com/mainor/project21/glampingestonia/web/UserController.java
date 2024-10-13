package com.mainor.project21.glampingestonia.web;

import com.mainor.project21.glampingestonia.dto.CreateUserRequest;
import com.mainor.project21.glampingestonia.dto.UserDto;
import com.mainor.project21.glampingestonia.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public UserDto getUser(@PathVariable String id) throws Exception {
        return userService.findById(id);
    }

}
