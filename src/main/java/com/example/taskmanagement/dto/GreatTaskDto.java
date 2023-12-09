package com.example.taskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Cущность пассажир  */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GreatTaskDto {
    String heading;
    String description;
    Status status;
    Priority priority;
    long author;
    long executor;
}
