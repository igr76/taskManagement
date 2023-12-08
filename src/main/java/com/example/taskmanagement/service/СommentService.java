package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.СommentDto;

import java.util.List;

public interface СommentService {
    List<СommentDto> getAllСommentsOfTask(int id);
    СommentDto greatСomment(СommentDto commentDto);
    void deleteСomment(int id);
}
