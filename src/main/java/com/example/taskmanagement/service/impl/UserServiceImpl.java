package com.example.taskmanagement.service.impl;


import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.exception.ElemNotFound;
import com.example.taskmanagement.mapper.UserMapper;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.UserService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Сервис пользователей
 */
//@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
  private UserRepository userRepository;
  private UserMapper userMapper;
  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  /**
   * Получить данные пользователя
   */
  @Override
  public UserDto getUser(String login/*, Authentication authentication*/) {
    log.info("Получить данные пользователя" );
    User user= new User();
    user=userRepository.findByLogin( login).orElseThrow(ElemNotFound::new);
    return userMapper.toDTO(user);
  }

  /**
   * Обновить данные пользователя
   */
  @Override
  public UserDto updateUser(UserDto newUserDto/*, Authentication authentication*/) {
    log.info("Обновить данные пользователя");
    User user= new User();
    user= userRepository.findByLogin(newUserDto.getLogin()).orElseThrow(ElemNotFound::new);
    user=userMapper.toEntity(newUserDto);
    userRepository.save(user);
    return newUserDto;
  }

  @Override
  public void deleteUser(String login/*, Authentication authentication*/) {
    log.info("Удалить пользователя");
    User user= new User();
    user= userRepository.findByLogin(login).orElseThrow(ElemNotFound::new);
    userRepository.delete(user);
  }

  @Override
  public UserDto greateUser(UserDto userDto/*, Authentication authentication*/) {
    log.info("Создать пользователя");
    User user= new User();
    user= userRepository.findByLogin(userDto.getLogin()).orElseThrow(ElemNotFound::new);
    user=userMapper.toEntity(userDto);
    userRepository.save(user);
    return userDto;
  }

  @Override
  public Optional<User> getByLogin(@NonNull String login) {
    return null;
  }


}
