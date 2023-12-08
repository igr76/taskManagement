package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.exception.ElemNotFound;
import com.example.taskmanagement.exception.UnsupportedOperationException;
import com.example.taskmanagement.mapper.TaskMapper;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskDto getTask(int id) {
        return taskMapper.toDTO(taskRepository.findById(id).orElseThrow(()->
                new ElemNotFound("Такого пользователя не существует")));
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskMapper.toListTaskDto(taskRepository.findAll());
    }

    @Override
    public TaskDto greatTask(TaskDto taskDto) {
        Optional<Task> task=taskRepository.findByHeading(taskDto.getHeading());
        if (task != null) {
            new  UnsupportedOperationException("Такая задача уже существует");
        }else   taskRepository.save(taskMapper.toEntity(taskDto));
        return taskDto;
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto) {
        Task task= new Task();
            task = taskRepository.findByHeading(taskDto.getHeading()).orElseThrow(()->
                    new ElemNotFound("Такой задачи не существует"));
        task.setHeading(taskDto.getHeading());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setPriority(taskDto.getPriority());

        taskRepository.save(task);
        return taskDto;
    }

    @Override
    public void deleteTask(String heading) {
        Task task= new Task();
            task = taskRepository.findByHeading(heading).orElseThrow(()->
                    new ElemNotFound("Такой задачи не существует"));
            taskRepository.delete(task);
    }
}
