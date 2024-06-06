package ru.otus.dbarsukov.ha.profiles.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.otus.dbarsukov.ha.profiles.model.LoginPost200Response;
import ru.otus.dbarsukov.ha.profiles.model.LoginPost500Response;
import ru.otus.dbarsukov.ha.profiles.model.LoginPostRequest;

@Validated
@Tag(name = "login", description = "the login API")
public interface LoginApi {

    /**
     * POST /login
     * Упрощенный процесс аутентификации путем передачи идентификатор пользователя и получения токена для дальнейшего прохождения авторизации
     *
     * @param loginPostRequest  (optional)
     * @return Успешная аутентификация (status code 200)
     *         or Невалидные данные (status code 400)
     *         or Пользователь не найден (status code 404)
     *         or Ошибка сервера (status code 500)
     *         or Ошибка сервера (status code 503)
     */
    @Operation(
        operationId = "loginPost",
        description = "Упрощенный процесс аутентификации путем передачи идентификатор пользователя и получения токена для дальнейшего прохождения авторизации",
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешная аутентификация", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost200Response.class))
            }),
            @ApiResponse(responseCode = "400", description = "Невалидные данные"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500Response.class))
            }),
            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500Response.class))
            })
        }
    )
    @PostMapping(
        value = "/login",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<LoginPost200Response> loginPost(
        @Parameter(name = "LoginPostRequest", description = "")
        @Valid @RequestBody(required = false) LoginPostRequest loginPostRequest
    );
}
