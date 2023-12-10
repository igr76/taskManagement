package com.example.taskmanagement.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

/**
 *  DTO для {@link com.example.taskmanagement.entity.User} сущности
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

  /** Логин пользователя  */
   String login;
  /** Пароль пользователя  */
   String passwordHash;
  /** Имя пользователя  */
   String name;
  /** Фамилия пользователя  */
   String surname;
  /** Отчество пользователя  */
   String patronymicName;
}
//{"login":"user1" ,"passwordHash":"user1", "name":"user1", "surname":"user1" ,"patronymicName":"user1"}