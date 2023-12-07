package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.СommentDto;
import com.example.taskmanagement.entity.СommentEntitty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface СommentMapper {
    @Mapping(target = "task.id", source = "task")
    @Mapping(target = "author.id", source = "author")
    @Mapping(target = "id", ignore = true)
    СommentEntitty toEntity(СommentDto commentDto);
    @Mapping(target = "task", source = "task.id")
    @Mapping(target = "author", source = "author.id")
    СommentDto toDTO(СommentEntitty comment);
}

