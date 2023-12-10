package com.example.taskmanagement.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 *  Регистрауионный DTO для {@link com.example.taskmanagement.entity.User} сущности
 */
@Setter
@Getter
public class RegistrationUserDto {
    /** Логин пользователя  */
    private String login;
    /** Пароль пользователя  */
    private String password;
    /** Пароль пользователя повторно */
    private String confirmPassword;
    /** Имя пользователя  */
    String name;
    /** Фамилия пользователя  */
    String surname;
    /** Отчество пользователя  */
    String patronymicName;

}
