package com.mainor.project21.glampingestonia.web;

import ee.eek.booking.dto.CreateUserRequest;
import ee.eek.booking.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto create(@RequestBody CreateUserRequest request){
        return userService.create(request);
    }

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable Long id){
        return userService.findById(id);
    }

}
