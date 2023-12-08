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
    user=userRepository.findByLogin( login).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    return userMapper.toDTO(user);
  }@Override
  public UserDto greateUser(UserDto userDto/*, Authentication authentication*/) {
    log.info("Создать пользователя");
    User user= new User();
      Optional<User> user1= userRepository.findByLogin(userDto.getLogin());
    if (user1 != null) {throw new UnsupportedOperationException("Такой пользователь уже существует");

    }else   { user=userMapper.toEntity(userDto);
    userRepository.save(user);}
    return userDto;
  }

  /**
   * Обновить данные пользователя
   */
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



  @Override
  public User getByLogin(@NonNull String login) {
    User user= new User();
    user= userRepository.findByLogin(login).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    return user;
  }


}
