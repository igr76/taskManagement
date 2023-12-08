package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.entity.Task;
import com.example.taskmanagement.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tasks")
@Slf4j
@RestController
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Получить пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDto> getTasks(@PathVariable(name = "id")
                                           @NotBlank(message = "id не должен быть пустым") int id/*, Authentication authentication*/) {
        log.info("controller Получить пользователя");
        return ResponseEntity.ok(taskService.getTask(id));
    }
    @Operation(summary = "Получить пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
    @GetMapping(value = "/all")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        log.info("controller Получить пользователя");
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @Operation(summary = "Создать пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    // @PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
    @PostMapping
    public ResponseEntity<TaskDto> greatTask(
            @RequestBody
            @NotBlank(message = "пользователь не должен быть пустым") TaskDto taskDto/*, Authentication authentication*/) {
        log.info("controller создать пользователя");
        return ResponseEntity.ok(taskService.greatTask(taskDto));
    }
    @Operation(summary = "Обновить пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    // @PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
    @PatchMapping()
    public ResponseEntity<TaskDto> updateTask(
            @RequestBody
            @NotBlank(message = "пользователь не должен быть пустым") TaskDto taskDto/*, Authentication authentication*/) {
        log.info("controller Обновить пользователя");
        return ResponseEntity.ok(taskService.updateTask(taskDto));
    }
    @Operation(summary = "Удалить пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{heading}")
    public void deleteTask(@PathVariable(name = "heading")
                           @NotBlank(message = "heading не должен быть пустым") String heading/*, Authentication authentication*/) {
        log.info("controller Удалить пользователя");
        taskService.deleteTask(heading);
    }
}
