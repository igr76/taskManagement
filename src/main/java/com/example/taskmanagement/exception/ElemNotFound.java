package com.example.taskmanagement.exception;

/** Ошибка - элемент не найден * {@link }*/
public class ElemNotFound extends RuntimeException {

  public ElemNotFound() {
  }
  public ElemNotFound(String textException) {
    super(textException);
  }
}

