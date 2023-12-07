package com.example.taskmanagement.entity;

import com.example.taskmanagement.dto.Priority;
import com.example.taskmanagement.dto.Status;
import jakarta.persistence.*;
import lombok.*;

/** Cущность пассажир  */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String heading;
    String description;
    Status status;
    Priority priority;
    @ManyToOne
   // @JoinColumn(name = "user.id")
    User author;
    @ManyToOne
   // @JoinColumn(name = "user.id")
    User executor;
}
