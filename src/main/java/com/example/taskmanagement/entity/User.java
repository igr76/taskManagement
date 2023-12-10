package com.example.taskmanagement.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/** Cущность пользователь  */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
  /** Номер пользователя  */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
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

