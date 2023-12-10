package com.example.taskmanagement.dto;

import com.example.taskmanagement.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

/**
 *  DTO для {@link com.example.taskmanagement.entity.Task} сущности
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {
    int id;
    /** Заголовок задачи  */
    String heading;
    /** Описание задачи  */
    String description;
    /** Статус задачи  */
    Status status;
    /** Приоритет задачи  */
    Priority priority;
    /** Автор задачи id */
    long author;
    /** Исполнитель задачи id */
    long executor;
}
 //  {"id":"1", "heading":"head" ,"description":"head",
//  "status":"Status.IN_PROGRESS", "priority":"Priority.AVERAGE" ,"author":"head", "executor":"head"}