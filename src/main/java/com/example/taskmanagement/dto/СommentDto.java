package com.example.taskmanagement.dto;

import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.entity.СommentEntity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

/**
 *  DTO для {@link СommentEntity} сущности
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class СommentDto {
    /** Номер комментария  */
    int id;
    /** Содержание комментария   */
    String comment;
    /** К какой задаче комментарий  */
    int task;
    /** Автор комментария  */
    int author;
}
