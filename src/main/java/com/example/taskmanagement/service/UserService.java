package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.User;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
/** Сервис пользователей*/
public interface UserService {
    /** Получить данные пользователя*/
    UserDto getUser(String login/*, Authentication authentication*/);
    /** Обновить данные пользователя*/
    UserDto updateUser(UserDto newUserDto/*, Authentication authentication*/);
    /** Удалить данные пользователя*/
    void deleteUser(String login/*, Authentication authentication*/);
    /** Создать пользователя*/
    UserDto greateUser(UserDto userDto/*, Authentication authentication*/);
    /** Получить данные пользователя ро логину*/
    public UserDetails loadUserBylogin(String login);
}
