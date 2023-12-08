package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.User;
import lombok.NonNull;

import java.util.Optional;

public interface UserService {
    UserDto getUser(String login/*, Authentication authentication*/);

    UserDto updateUser(UserDto newUserDto/*, Authentication authentication*/);

    void deleteUser(String login/*, Authentication authentication*/);

    UserDto greateUser(UserDto userDto/*, Authentication authentication*/);

    public User getByLogin(@NonNull String login);
}
