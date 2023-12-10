package com.example.taskmanagement.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 *  Регистрауионный DTO для {@link com.example.taskmanagement.entity.User} сущности
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistrationUserDto {
    /** Логин пользователя  */
     String login;
    /** Пароль пользователя  */
    String password;
    /** Пароль пользователя повторно */
     String confirmPassword;
    /** Имя пользователя  */
    String name;
    /** Фамилия пользователя  */
    String surname;
    /** Отчество пользователя  */
    String patronymicName;

}
