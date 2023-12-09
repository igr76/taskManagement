package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.dto.СommentDto;
import com.example.taskmanagement.service.СommentService;
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

@RequestMapping("/comment")
@Slf4j
@RestController
public class СommentController {
    private СommentService commentService;

    public СommentController(СommentService commentService) {
        this.commentService = commentService;
    }

    @Operation(summary = "Получить все комментарии к задаче")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
    @GetMapping(value = "/all/{id}")
    public ResponseEntity<List<СommentDto>> getAllСommentsOfTask(@PathVariable(name = "id")
                                                         @NotBlank(message = "id задачи") int id) {
        log.info("controller Получить все комментарии");
        return ResponseEntity.ok(commentService.getAllСommentsOfTask(id));
    }
    @Operation(summary = "Создать комментарий")
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
    public ResponseEntity<СommentDto> greatСomment(
            @RequestBody
            @NotBlank(message = "задача не должна быть пустой") СommentDto commentDto/*, Authentication authentication*/) {
        log.info("controller создать комментарий");
        return ResponseEntity.ok(commentService.greatСomment(commentDto));
    }
    @Operation(summary = "Удалить комментарий")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable(name = "id")
                               @NotBlank(message = "id задачи") int id/*, Authentication authentication*/) {
        log.info("controller Удалить комментарий");
        commentService.deleteСomment(id);
    }
}
