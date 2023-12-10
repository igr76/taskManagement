package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.JwtRequest;
import com.example.taskmanagement.dto.JwtResponse;
import com.example.taskmanagement.dto.RegistrationUserDto;
import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.exception.AppError;
import com.example.taskmanagement.mapper.UserMapper;
import com.example.taskmanagement.service.impl.UserServiceImpl;
import com.example.taskmanagement.utils.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {
    private final UserServiceImpl userService;
    private final JwtTokenUtils jwtTokenUtils;
    private AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    public AuthService(UserServiceImpl userService, JwtTokenUtils jwtTokenUtils,
                         UserMapper userMapper) {
        this.userService = userService;
        this.jwtTokenUtils = jwtTokenUtils;
        this.userMapper = userMapper;
    }

    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserBylogin(authRequest.getUsername());
        String token = jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        if (!registrationUserDto.getPassword().equals(registrationUserDto.getConfirmPassword())) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пароли не совпадают"), HttpStatus.BAD_REQUEST);
        }
        if (userService.loadUserBylogin(registrationUserDto.getLogin()).isEnabled()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.greateUser(userMapper.toDTOreg(registrationUserDto)));
    }
}
