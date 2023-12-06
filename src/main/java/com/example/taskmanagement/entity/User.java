package com.example.taskmanagement.entity;


import jakarta.persistence.*;
import lombok.*;

/** Cущность пассажир  */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String login;
  private String passwordHash;
  private String name;
  private String surname;
  private String patronymicName;
}

