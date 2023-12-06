package com.example.taskmanagement.controller;


import com.example.taskmanagement.dto.UserDto;
import com.example.taskmanagement.service.UserService;
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

@RequestMapping("/users")
@Slf4j
@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
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
  @GetMapping(value = "/{login}")
  public ResponseEntity<UserDto> getUser(@PathVariable(name = "login")
                                           @NotBlank(message = "ad_pk не должен быть пустым") String login/*, Authentication authentication*/) {
    log.info("controller Получить пользователя");
    return ResponseEntity.ok(userService.getUser(login));
  }
  @Operation(summary = "Создать пользователя")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                  array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
          @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
  })
 // @PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
  @PostMapping
  public ResponseEntity<UserDto> greaetUser(
          @RequestBody
          @NotBlank(message = "пользователь не должен быть пустым") UserDto userDto/*, Authentication authentication*/) {
    log.info("controller создать пользователя");
    return ResponseEntity.ok(userService.greateUser(userDto));
  }
  @Operation(summary = "Обновить пользователя")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "OK", content = @Content(
              array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
      @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
      @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
      @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
      @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
  })
 // @PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
  @PatchMapping()
  public ResponseEntity<UserDto> updateUser(
          @RequestBody
      @NotBlank(message = "пользователь не должен быть пустым") UserDto userDto/*, Authentication authentication*/) {
    log.info("controller Обновить пользователя");
    return ResponseEntity.ok(userService.updateUser(userDto));
  }
    @Operation(summary = "Удалить пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "No Content", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{login}")
    public void deleteUser(@PathVariable(name = "login")
                               @NotBlank(message = "логин не должен быть пустым") String login/*, Authentication authentication*/) {
        log.info("controller Удалить пользователя");
         userService.deleteUser(login);
    }




}