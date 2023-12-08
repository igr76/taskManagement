package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.СommentDto;
import com.example.taskmanagement.entity.СommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface СommentMapper {
    @Mapping(target = "task.id", source = "task")
    @Mapping(target = "author.id", source = "author")
    СommentEntity toEntity(СommentDto commentDto);
    @Mapping(target = "task", source = "task.id")
    @Mapping(target = "author", source = "author.id")
    СommentDto toDTO(СommentEntity comment);

    List<СommentDto> toCcommentListDto(List<СommentEntity> commentList);
}

