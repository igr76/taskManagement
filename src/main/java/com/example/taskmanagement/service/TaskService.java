package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.GreatTaskDto;
import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TaskService {
    TaskDto getTask(String heading);
    List<TaskDto> getTaskOfAuthor(String author);
    List<TaskDto> getTaskOfPriority(String priority);
    List<TaskDto> getAllTasks();
    void greatTask(GreatTaskDto greatTaskDto);
    TaskDto updateTask(TaskDto taskDto);
    TaskDto updatePriorityTask(TaskDto taskDto);
    void deleteTask(String heading);

}
