package com.example.taskmanagement.service.impl;


import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.exception.ElemNotFound;
import com.example.taskmanagement.mapper.UserMapper;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.UserService;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

/** Реализация сервиса пользователей*/
@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
  private  UserRepository userRepository;
  private  UserMapper userMapper;

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public UserDto getUser(String login) {
    log.debug("Получить данные пользователя" );
    User user= new User();
    user=userRepository.findByLogin( login).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    return userMapper.toDTO(user);
  }@Override
  public UserDto greateUser(UserDto userDto) {
    log.debug("Создать пользователя");
    User user= new User();
    Optional<User> user1= null;
    try {
      user= userRepository.findByLogin(userDto.getLogin()).orElseThrow(ElemNotFound::new);
      throw new UnsupportedOperationException("Такой пользователь уже существует");
    } catch (ElemNotFound e) {
      userRepository.save(userMapper.toEntity(userDto));
      return userDto;
    }

  }
  @Override
  public UserDto updateUser(UserDto newUserDto) {
    log.debug("Обновить данные пользователя");
    User user= new User();
    user= userRepository.findByLogin(newUserDto.getLogin()).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    user=userMapper.toEntity(newUserDto);
    userRepository.save(user);
    return newUserDto;
  }

  @Override
  public void deleteUser(String login) {
    log.debug("Удалить пользователя");
    User user= new User();
    user= userRepository.findByLogin(login).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует"));
    userRepository.delete(user);
  }

  @Override
  @Transactional
  public UserDetails loadUserBylogin(String login) {
    User user = userRepository.findByLogin(login).orElseThrow(()->
            new ElemNotFound("Такого пользователя не существует")
    );
    return new org.springframework.security.core.userdetails.User(
            user.getName(),
            user.getPasswordHash(),null);
  }


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return loadUserBylogin(username);
  }
}
