package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.Task;

import java.util.List;

public interface TaskService {
    Task getTask(int id);
    List<Task> getTasks();
    TaskDto greatTask(TaskDto taskDto);
    TaskDto updateTask(TaskDto taskDto);
    void deleteTask(TaskDto taskDto);

}
