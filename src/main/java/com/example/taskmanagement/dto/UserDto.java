package com.example.taskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/** Cущность пассажир  */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

  private String login;
  private String passwordHash;
  private String name;
  private String surname;
  private String patronymicName;




}
