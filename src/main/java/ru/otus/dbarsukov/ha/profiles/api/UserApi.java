package ru.otus.dbarsukov.ha.profiles.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.otus.dbarsukov.ha.profiles.model.LoginPost500Response;
import ru.otus.dbarsukov.ha.profiles.model.User;
import ru.otus.dbarsukov.ha.profiles.model.UserRegisterPost200Response;
import ru.otus.dbarsukov.ha.profiles.model.UserRegisterPostRequest;

@Validated
@Tag(name = "user", description = "the user API")
public interface UserApi {

    /**
     * GET /user/get/{id}
     * Получение анкеты пользователя
     *
     * @param id Идентификатор пользователя (required)
     * @return Успешное получение анкеты пользователя (status code 200)
     *         or Невалидные данные (status code 400)
     *         or Анкета не найдена (status code 404)
     *         or Ошибка сервера (status code 500)
     *         or Ошибка сервера (status code 503)
     */
    @Operation(
        operationId = "userGetIdGet",
        description = "Получение анкеты пользователя",
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешное получение анкеты пользователя", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            }),
            @ApiResponse(responseCode = "400", description = "Невалидные данные"),
            @ApiResponse(responseCode = "404", description = "Анкета не найдена"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500Response.class))
            }),
            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500Response.class))
            })
        }
    )
    @GetMapping(
        value = "/user/get/{id}",
        produces = { "application/json" }
    )
    ResponseEntity<User> userGetIdGet(
        @Parameter(name = "id", description = "Идентификатор пользователя", required = true, in = ParameterIn.PATH)
        @PathVariable("id") String id
    );


    /**
     * POST /user/register
     * Регистрация нового пользователя
     *
     * @param userRegisterPostRequest  (optional)
     * @return Успешная регистрация (status code 200)
     *         or Невалидные данные (status code 400)
     *         or Ошибка сервера (status code 500)
     *         or Ошибка сервера (status code 503)
     */
    @Operation(
        operationId = "userRegisterPost",
        description = "Регистрация нового пользователя",
        responses = {
            @ApiResponse(responseCode = "200", description = "Успешная регистрация", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UserRegisterPost200Response.class))
            }),
            @ApiResponse(responseCode = "400", description = "Невалидные данные"),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500Response.class))
            }),
            @ApiResponse(responseCode = "503", description = "Ошибка сервера", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = LoginPost500Response.class))
            })
        }
    )
    @PostMapping(
        value = "/user/register",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<UserRegisterPost200Response> userRegisterPost(
        @Parameter(name = "UserRegisterPostRequest", description = "")
        @Valid @RequestBody(required = false) UserRegisterPostRequest userRegisterPostRequest
    );
}
