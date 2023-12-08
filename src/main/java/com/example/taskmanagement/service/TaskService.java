package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TaskService {
    TaskDto getTask(String heading);
    List<TaskDto> getAllTasks();
    TaskDto greatTask(TaskDto taskDto);
    TaskDto updateTask(TaskDto taskDto);
    void deleteTask(String heading);

}
