package com.example.taskmanagement;

import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.User;
import com.example.taskmanagement.exception.ElemNotFound;
import com.example.taskmanagement.mapper.UserMapper;
import com.example.taskmanagement.repository.UserRepository;
import com.example.taskmanagement.service.UserService;
import com.example.taskmanagement.service.impl.UserServiceImpl;
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
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService = new UserServiceImpl(userRepository,userMapper);
    @Test
    void getUserTest() {
        User user = getUser();UserDto userDto = getUserDto();

        when(userRepository.findByLogin(any())).thenReturn(Optional.ofNullable(user));
        when(userMapper.toDTO(any())).thenReturn(userDto);
        assertThat(userService.getUser(any())).isEqualTo(userDto);
        verify(userRepository, times(1)).findByLogin(any());
    }
    @Test
    void getUserTestNegative() {
        when(userRepository.findByLogin(any())).thenReturn(Optional.ofNullable(null));
        assertThatExceptionOfType(ElemNotFound.class).isThrownBy(() -> userService.getUser("name"));
        verify(userRepository, times(1)).findByLogin(any());
    }
    @Test
    void greateUserTest() {
        User user = getUser();UserDto userDto = getUserDto();

      //  when(userRepository.findByLogin(any())).thenReturn(null);
        assertThat(userService.greateUser(userDto)).isEqualTo(userDto);
        verify(userRepository, times(1)).findByLogin(any());
    }
    @Test
    void greateUserTestNegative() {
        when(userRepository.findByLogin(any())).thenReturn(Optional.ofNullable(getUser()));
        assertThatExceptionOfType(UnsupportedOperationException.class).isThrownBy(() -> userService.greateUser(getUserDto()));
        verify(userRepository, times(1)).findByLogin(any());
    }
    @Test
    void updateUserTest() {
        User user = getUser();UserDto userDto = getUserDto();

        when(userRepository.findByLogin(any())).thenReturn(Optional.ofNullable(user));
        when(userMapper.toEntity(any())).thenReturn(user);
        when(userRepository.save(any())).thenReturn(user);
        assertThat(userService.updateUser(userDto)).isEqualTo(userDto);
        verify(userRepository, times(1)).findByLogin(any());
    }
    @Test
    void updateUserTestNegative() {
        when(userRepository.findByLogin(any())).thenReturn(Optional.ofNullable(null));
        assertThatExceptionOfType(ElemNotFound.class).isThrownBy(() -> userService.updateUser(getUserDto()));
        verify(userRepository, times(1)).findByLogin(any());
    }
    @Test
    void deleteUserTest() {
        User user = getUser();

        when(userRepository.findByLogin(any())).thenReturn(Optional.ofNullable(user));
        userService.deleteUser("login");;
        verify(userRepository, times(1)).findByLogin(any());
    }
    @Test
    void deleteUserTestNegative() {
        when(userRepository.findByLogin(any())).thenReturn(Optional.ofNullable(null));
        assertThatExceptionOfType(ElemNotFound.class).isThrownBy(() -> userService.deleteUser("name"));
        verify(userRepository, times(1)).findByLogin(any());
    }

    User getUser() {
        User user =new User(1,"login","1111",
                "name1","surname","patronymicName");
        return user;
    }

    UserDto getUserDto() {
        UserDto userDto = new UserDto("login","1111",
                "name1","surname","patronymicName");
        return userDto;
    }
}
