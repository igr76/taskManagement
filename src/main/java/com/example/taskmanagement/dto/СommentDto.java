package com.example.taskmanagement.dto;

import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.entity.User;
import jakarta.persistence.ManyToOne;
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
public class СommentDto {
    int id;
    String comment;
    int task;
    int author;
}
