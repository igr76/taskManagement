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

    @Operation(summary = "Получить задачу по заголовку")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
    @GetMapping(value = "/{heading}")
    public ResponseEntity<TaskDto> getTasks(@PathVariable(name = "heading")
                                           @NotBlank(message = "заголовок не должен быть пустым") String heading/*, Authentication authentication*/) {
        log.info("controller Получить задачу");
        return ResponseEntity.ok(taskService.getTask(heading));
    }
    @Operation(summary = "Получить все задачи")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
    @GetMapping(value = "/all")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        log.info("controller Получить все задачи");
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    @Operation(summary = "Получить все задачи")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
    @GetMapping(value = "/all/{author}")
    public ResponseEntity<List<TaskDto>> getTaskOfAuthor(@PathVariable(name = "author")
                                                             @NotBlank(message = "заголовок не должен быть пустым") String author) {
        log.info("controller Получить все задачи");
        return ResponseEntity.ok(taskService.getTaskOfAuthor(author));
    }
    @Operation(summary = "Получить все задачи")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
    @GetMapping(value = "/all/{priority}")
    public ResponseEntity<List<TaskDto>> getTaskOfPriority(@PathVariable(name = "priority")
                                                         @NotBlank(message = "заголовок не должен быть пустым") String priority) {
        log.info("controller Получить все задачи");
        return ResponseEntity.ok(taskService.getTaskOfPriority(priority));
    }
    @Operation(summary = "Создать задачу")
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
            @NotBlank(message = "задача не должна быть пустой") TaskDto taskDto/*, Authentication authentication*/) {
        log.info("controller создать задачу");
        return ResponseEntity.ok(taskService.greatTask(taskDto));
    }
    @Operation(summary = "Обновить задачу")
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
            @NotBlank(message = "задача не должна быть пустой") TaskDto taskDto/*, Authentication authentication*/) {
        log.info("controller Обновить задачу");
        return ResponseEntity.ok(taskService.updateTask(taskDto));
    }
    @Operation(summary = "Обновить статус исполнения задачи")
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
    public ResponseEntity<TaskDto> updatePriorityTask(
            @RequestBody
            @NotBlank(message = "задача не должна быть пустой") TaskDto taskDto/*, Authentication authentication*/) {
        log.info("controller Обновить статус исполнения задачи");
        return ResponseEntity.ok(taskService.updatePriorityTask(taskDto));
    }
    @Operation(summary = "Удалить задачу")
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
                           @NotBlank(message = "заголовок не должен быть пустым") String heading/*, Authentication authentication*/) {
        log.info("controller Удалить задачу");
        taskService.deleteTask(heading);
    }
}
