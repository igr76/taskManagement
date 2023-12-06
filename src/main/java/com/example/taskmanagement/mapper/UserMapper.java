package com.example.taskmanagement.mapper;

import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    User toEntity(UserDto userDto);

    UserDto toDTO(User userEntity);
}
