package com.example.taskmanagement.service.impl;


import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.exception.ElemNotFound;
import com.example.taskmanagement.mapper.UserMapper;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/** Реализация сервиса пользователей*/
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  @Override
  public UserDto getUser(String login/*, Authentication authentication*/) {
    log.info("Получить данные пользователя" );
    User user= new User();
    user=userRepository.findByLogin( login).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    return userMapper.toDTO(user);
  }@Override
  public UserDto greateUser(UserDto userDto/*, Authentication authentication*/) {
    log.info("Создать пользователя");
    User user= new User();
    User user1= null;
    try {
      user1 = userRepository.findByLogin(userDto.getLogin()).orElseThrow(ElemNotFound::new);
    } catch (ElemNotFound e) {
      user=userMapper.toEntity(userDto);
      userRepository.save(user);
      return userDto;
    }
    throw new UnsupportedOperationException("Такой пользователь уже существует");
  }
  @Override
  public UserDto updateUser(UserDto newUserDto/*, Authentication authentication*/) {
    log.info("Обновить данные пользователя");
    User user= new User();
    user= userRepository.findByLogin(newUserDto.getLogin()).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    user=userMapper.toEntity(newUserDto);
    userRepository.save(user);
    return newUserDto;
  }

  @Override
  public void deleteUser(String login/*, Authentication authentication*/) {
    log.info("Удалить пользователя");
    User user= new User();
    user= userRepository.findByLogin(login).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    userRepository.delete(user);
  }
}
