package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.dto.СommentDto;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.entity.СommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
/**
 * маппер для {@link User} готовый dto {@link UserDto}
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto userDto);

    UserDto toDTO(User userEntity);
}
