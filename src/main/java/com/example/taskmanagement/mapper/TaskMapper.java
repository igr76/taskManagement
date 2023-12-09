package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.GreatTaskDto;
import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(target = "author.id", source = "author")
    @Mapping(target = "executor.id", source = "executor")
    @Mapping(target = "id", ignore = true)
    Task toEntity(GreatTaskDto greatTaskDto);
    @Mapping(target = "author", source = "author.id")
    @Mapping(target = "executor", source = "executor.id")
    TaskDto toDTO(Task task);

    List<TaskDto> toListTaskDto(List<Task> taskList);
}
