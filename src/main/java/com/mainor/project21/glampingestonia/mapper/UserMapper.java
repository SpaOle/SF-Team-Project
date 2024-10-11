package com.mainor.project21.glampingestonia.mapper;

import com.mainor.project21.glampingestonia.model.User;
import com.mainor.project21.glampingestonia.dto.CreateUserRequest;
import com.mainor.project21.glampingestonia.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static User toEntity(CreateUserRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }
}
