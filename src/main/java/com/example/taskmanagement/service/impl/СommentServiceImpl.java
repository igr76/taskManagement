package com.example.taskmanagement.service.impl;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.dto.СommentDto;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.entity.СommentEntity;
import com.example.taskmanagement.exception.ElemNotFound;
import com.example.taskmanagement.exception.UnsupportedOperationException;
import com.example.taskmanagement.mapper.СommentMapper;
import com.example.taskmanagement.repository.СommentRepository;
import com.example.taskmanagement.service.СommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/** Реализация сервиса комментариев*/
@RequiredArgsConstructor
@Service
public class СommentServiceImpl implements СommentService {
    private final СommentRepository commentRepository;
    private final СommentMapper commentMapper;

    @Override
    public List<СommentDto> getAllСommentsOfTask(int id) {
       return commentMapper.toCcommentListDto(commentRepository.findByTaskId(id));
    }

    @Override
    public СommentDto greatСomment(СommentDto commentDto) {
        commentRepository.save(commentMapper.toEntity(commentDto));
        return commentDto;
    }

    @Override
    public void deleteСomment(int id) {
        СommentEntity commentEntity= new СommentEntity();
        commentEntity = commentRepository.findById(id).orElseThrow(()->
                new ElemNotFound("Такой задачи не существует"));
        commentRepository.delete(commentEntity);
    }
}
