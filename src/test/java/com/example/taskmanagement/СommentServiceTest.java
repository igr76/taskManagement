package com.example.taskmanagement;

import com.example.taskmanagement.dto.Priority;
import com.example.taskmanagement.dto.Status;
import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.dto.СommentDto;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.entity.СommentEntity;
import com.example.taskmanagement.mapper.СommentMapper;
import com.example.taskmanagement.repository.СommentRepository;
import com.example.taskmanagement.service.impl.СommentServiceImpl;
import com.example.taskmanagement.service.СommentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class СommentServiceTest {
    @Mock
    private СommentRepository commentRepository;
    @Mock
    private СommentMapper commentMapper;
    @InjectMocks
    private  СommentServiceImpl сommentService = new СommentServiceImpl(commentRepository,commentMapper);

    @Test
    void getAllСommentsOfTaskTest() {
        Collection<СommentEntity> entityList=new ArrayList<>();
        entityList.add(getСommentEntity());
        Collection<СommentDto> dtoList=new ArrayList<>();
        dtoList.add(getСommentDto());

        when(commentRepository.findByTaskId(1)).thenReturn((List<СommentEntity>) entityList);
        when(commentMapper.toCcommentListDto(any())).thenReturn((List<СommentDto>) dtoList);
        assertThat(сommentService.getAllСommentsOfTask(1)).isEqualTo(dtoList);
        verify(commentRepository, times(1)).findByTaskId(1);
    }
    @Test
    void greatСommentTest() {
        СommentEntity commentEntity=getСommentEntity();СommentDto commentDto=getСommentDto();

        assertThat(сommentService.greatСomment(commentDto)).isEqualTo(commentDto);
        verify(commentRepository, times(1)).save(any());
    }
    @Test
    void deleteСommentTest() {
        СommentEntity commentEntity=getСommentEntity();

        when(commentRepository.findById(any())).thenReturn(Optional.ofNullable(commentEntity));
        сommentService.deleteСomment(1);
        verify(commentRepository, times(1)).findById(any());
    }

    СommentEntity getСommentEntity() {
        СommentEntity commentEntity = new СommentEntity(1,"comment",getTask(),null);
        return commentEntity;
    }
    СommentDto getСommentDto() {
        СommentDto commentDto = new СommentDto(1,"comment",1,1);
        return commentDto;
    }
    private Task getTask() {
        Task task = new Task(1,"заголовок","описание", Status.IN_PROGRESS, Priority.AVERAGE,null,null);
        return task;
    }
}
