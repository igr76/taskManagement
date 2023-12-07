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
public class СommentEntitty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String comment;
    @ManyToOne
    Task task;
    @ManyToOne
    User author;
}
