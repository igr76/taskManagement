package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.dto.GreatTaskDto;
import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.exception.ElemNotFound;
import com.example.taskmanagement.mapper.TaskMapper;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.repository.СommentRepository;
import com.example.taskmanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/** Реализация сервиса задач*/
@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    private  TaskRepository taskRepository;
    private  TaskMapper taskMapper;
    private  СommentRepository commentRepository;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper, СommentRepository commentRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.commentRepository = commentRepository;
    }

    @Override
    public TaskDto getTask(String heading) {
        return taskMapper.toDTO(taskRepository.findByHeading(heading).orElseThrow(()->
                new ElemNotFound("Такого пользователя не существует")));
    }
    @Override
    public List<TaskDto> getTaskOfAuthor(String author) {
        return taskMapper.toListTaskDto(taskRepository.findByAuthor(author).orElseThrow(()->
                new ElemNotFound("Такого пользователя не существует")));
    }
    @Override
    public List<TaskDto> getTaskOfExecutor(String executor) {
        return taskMapper.toListTaskDto(taskRepository.findByExecutor(executor).orElseThrow(()->
                new ElemNotFound("Такого пользователя не существует")));
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskMapper.toListTaskDto(taskRepository.findAll());
    }

    @Override
    public void greatTask(GreatTaskDto greatTaskDto) {
        Task task;
        try {
            task=taskRepository.findByHeading(greatTaskDto.getHeading()).orElseThrow(ElemNotFound::new);
            throw new UnsupportedOperationException("Такая задача уже существует");
        } catch (ElemNotFound e) {
            taskRepository.save(taskMapper.toEntity(greatTaskDto));}
//        if (task != null) {
//            log.info("111111");
//            throw new  UnsupportedOperationException("Такая задача уже существует");
//        }else   taskRepository.save(taskMapper.toEntity(greatTaskDto));

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
    public TaskDto updateStatusTask(TaskDto taskDto) {
        Task task= new Task();
        task = taskRepository.findByHeading(taskDto.getHeading()).orElseThrow(()->
                new ElemNotFound("Такой задачи не существует"));
        task.setStatus(taskDto.getStatus());

        taskRepository.save(task);
        return taskMapper.toDTO(task);
    }

    @Override
    public void deleteTask(String heading) {
        Task task= new Task();
            task = taskRepository.findByHeading(heading).orElseThrow(()->
                    new ElemNotFound("Такой задачи не существует"));
        commentRepository.deleteAllFromTask(task.getId());
        taskRepository.delete(task);
    }
}
