package com.example.taskmanagement.dto;

import com.example.taskmanagement.entity.User;
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
@Component
public class TaskDto {
    String heading;
    String description;
    Status status;
    Priority priority;
    long author;
    long executor;
}
