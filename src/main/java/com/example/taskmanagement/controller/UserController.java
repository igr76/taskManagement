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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/** Контроллер комментариев  */
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {
  private final UserService userService;
  @Operation(summary = "Получить пользователя")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(
                  array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
          @ApiResponse(responseCode = "204", description = "нет содержимого", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "401", description = "неверная авторизация или аутентификация", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "404", description = "Не найдено", content = @Content(schema = @Schema()))
  })
  //@PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
  @GetMapping(value = "/{login}")
  public ResponseEntity<UserDto> getUser(@PathVariable(name = "login")
                                           @NotBlank(message = "ad_pk не должен быть пустым") String login/*, Authentication authentication*/) {
    log.debug("controller Получить пользователя");
    return ResponseEntity.ok(userService.getUser(login));
  }
  @Operation(summary = "Создать пользователя")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(
                  array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
          @ApiResponse(responseCode = "204", description = "нет содержимого", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "401", description = "неверная авторизация или аутентификация", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "404", description = "Не найдено", content = @Content(schema = @Schema()))
  })
 // @PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
  @PostMapping
  public ResponseEntity<UserDto> greaetUser(
          @RequestBody
          @NotBlank(message = "пользователь не должен быть пустым") UserDto userDto/*, Authentication authentication*/) {
    log.debug("controller создать пользователя");
    return ResponseEntity.ok(userService.greateUser(userDto));
  }
  @Operation(summary = "Обновить пользователя")
  @ApiResponses({
          @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(
                  array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
          @ApiResponse(responseCode = "204", description = "нет содержимого", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "401", description = "неверная авторизация или аутентификация", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content(schema = @Schema())),
          @ApiResponse(responseCode = "404", description = "Не найдено", content = @Content(schema = @Schema()))
  })
 // @PreAuthorize("hasAuthority('ADMIN')"+"|| 'user.login'")
  @PatchMapping()
  public ResponseEntity<UserDto> updateUser(
          @RequestBody
      @NotBlank(message = "пользователь не должен быть пустым") UserDto userDto/*, Authentication authentication*/) {
    log.debug("controller Обновить пользователя");
    return ResponseEntity.ok(userService.updateUser(userDto));
  }
    @Operation(summary = "Удалить пользователя")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешно", content = @Content(
                    array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))),
            @ApiResponse(responseCode = "204", description = "нет содержимого", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "401", description = "неверная авторизация или аутентификация", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "403", description = "Доступ запрещен", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Не найдено", content = @Content(schema = @Schema()))
    })
    //@PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{login}")
    public void deleteUser(@PathVariable(name = "login")
                               @NotBlank(message = "логин не должен быть пустым") String login/*, Authentication authentication*/) {
        log.debug("controller Удалить пользователя");
         userService.deleteUser(login);
    }




}