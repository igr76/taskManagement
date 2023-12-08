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
@Table(name = "comments")
public class СommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String comment;
    @ManyToOne
    Task task;
    @ManyToOne
    User author;
}
