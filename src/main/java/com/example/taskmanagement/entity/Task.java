package com.example.taskmanagement.entity;

import com.example.taskmanagement.dto.Priority;
import com.example.taskmanagement.dto.Status;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/** Cущность задач  */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tasks")
public class Task {
    /** номер задачи  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    /** Заголовок задачи  */
    String heading;
    /** Описание задачи  */
    String description;
    /** Статус задачи  */
    Status status;
    /** Приоритет задачи  */
    Priority priority;
    /** Автор задачи  */
    @ManyToOne
    User author;
    /** Исполнитель задачи  */
    @ManyToOne
    User executor;
}
