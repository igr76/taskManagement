package com.example.taskmanagement.exception;

/** Ошибка при создании: Такой пользователь уже существует для greateUser  */
public class UnsupportedOperationException extends RuntimeException{
    public UnsupportedOperationException(String message) {
        super(message);
    }
}
