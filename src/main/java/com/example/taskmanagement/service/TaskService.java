package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.GreatTaskDto;
import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;
/** Сервис задач*/
@Service
public interface TaskService {
    /** Получить задачу по заголовку
     * @param heading - заголовок задачи*/
    TaskDto getTask(String heading);
    /** Получить все задачи  автора
     * @param author - автор задачи*/
    List<TaskDto> getTaskOfAuthor(String author);
    /** Получить все задачи  исполнителя
     * @param priority - исполнитель задачи*/
    List<TaskDto> getTaskOfExecutor(String priority);
    /** Получить все задачи*/
    List<TaskDto> getAllTasks();
    /** Создать задачу
     * @param greatTaskDto - тело задачи*/
    void greatTask(GreatTaskDto greatTaskDto);
    /** Обновить задачу
     * @param taskDto - тело задачи*/
    TaskDto updateTask(TaskDto taskDto);
    /** Изменить статус задачи
     * @param taskDto - тело задачи*/
    TaskDto updateStatusTask(TaskDto taskDto);
    /** Удалить задачу по заголовку
     * @param heading - заголовок задачи*/
    void deleteTask(String heading);

}
