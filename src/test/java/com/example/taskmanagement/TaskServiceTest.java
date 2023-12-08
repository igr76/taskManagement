package com.example.taskmanagement;

import com.example.taskmanagement.dto.Priority;
import com.example.taskmanagement.dto.Status;
import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.exception.ElemNotFound;
import com.example.taskmanagement.exception.UnsupportedOperationException;
import com.example.taskmanagement.mapper.TaskMapper;
import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;
    @Mock
    private TaskMapper taskMapper;
    @InjectMocks
    private TaskServiceImpl taskService = new TaskServiceImpl(taskRepository,taskMapper);
    @Test
    void getTaskTest() {
        Task task=getTask();TaskDto taskDto=getTaskDto();

        when(taskRepository.findByHeading(any())).thenReturn(Optional.ofNullable(task));
        when(taskMapper.toDTO(any())).thenReturn(taskDto);
        assertThat(taskService.getTask(any())).isEqualTo(taskDto);
        verify(taskRepository, times(1)).findByHeading(any());
    }
    @Test
    void getTaskTestNegative() {
        when(taskRepository.findByHeading(any())).thenReturn(Optional.ofNullable(null));
        assertThatExceptionOfType(ElemNotFound.class).isThrownBy(() -> taskService.getTask("заголовок1"));
        verify(taskRepository, times(1)).findByHeading(any());
    }

       @Test
    void greatTaskTest() {
           Task task=getTask();TaskDto taskDto=getTaskDto();

        when(taskRepository.findByHeading(any())).thenReturn(null);
        assertThat(taskService.greatTask(taskDto)).isEqualTo(taskDto);
        verify(taskRepository, times(1)).findByHeading(any());
    }
    @Test
    void greatTaskTestNegative() {
        Task task=getTask();TaskDto taskDto=getTaskDto();

        when(taskRepository.findByHeading(any())).thenReturn(Optional.ofNullable(task));
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> taskService.greatTask(taskDto));
        verify(taskRepository, times(1)).findByHeading(any());
    }
    @Test
    void updateTaskTest() {
        Task task=getTask();TaskDto taskDto=getTaskDto();

        when(taskRepository.findByHeading(any())).thenReturn(Optional.ofNullable(task));
        when(taskRepository.save(any())).thenReturn(task);
        assertThat(taskService.updateTask(taskDto)).isEqualTo(taskDto);
        verify(taskRepository, times(1)).findByHeading(any());
    }
    @Test
    void updateTaskTestNegative() {
        TaskDto taskDto=getTaskDto();

        when(taskRepository.findByHeading(any())).thenReturn(Optional.ofNullable(null));
        assertThatExceptionOfType(ElemNotFound.class).isThrownBy(() -> taskService.updateTask(taskDto));
        verify(taskRepository, times(1)).findByHeading(any());
    }
    @Test
    void deleteTaskTest() {
        Task task=getTask();

        when(taskRepository.findByHeading(any())).thenReturn(Optional.ofNullable(task));
        taskService.deleteTask("login");
        //   doNothing().when(userRepository).delete(any());
        verify(taskRepository, times(1)).findByHeading(any());
    }
    @Test
    void deleteTaskTestNegative() {
        TaskDto taskDto=getTaskDto();

        when(taskRepository.findByHeading(any())).thenReturn(Optional.ofNullable(null));
        assertThatExceptionOfType(ElemNotFound.class).isThrownBy(() -> taskService.deleteTask("заголовок"));
        verify(taskRepository, times(1)).findByHeading(any());
    }
    private Task getTask() {
        Task task = new Task(1,"заголовок","описание", Status.IN_PROGRESS, Priority.AVERAGE,getUser(),getUser());
        return task;
    }

    private TaskDto getTaskDto() {
        TaskDto taskDto=new TaskDto(1,"заголовок","описание", Status.IN_PROGRESS, Priority.AVERAGE,1L,1L);
        return taskDto;
    }
    private User getUser() {
        User user =new User(1,"login","1111",
                "name1","surname","patronymicName");
        return user;
    }

}
