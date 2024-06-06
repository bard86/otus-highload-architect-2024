package ru.otus.dbarsukov.ha.profiles.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.dbarsukov.ha.profiles.api.UserApi;
import ru.otus.dbarsukov.ha.profiles.model.User;
import ru.otus.dbarsukov.ha.profiles.model.UserRegisterPost200Response;
import ru.otus.dbarsukov.ha.profiles.model.UserRegisterPostRequest;
import ru.otus.dbarsukov.ha.profiles.service.UserService;

@Controller
@RequestMapping("${application.base-path}")
@RequiredArgsConstructor
public class UserApiController implements UserApi {

    private final UserService userService;

    @Override
    public ResponseEntity<User> userGetIdGet(String id) {
        return null;
    }

    @Override
    public ResponseEntity<UserRegisterPost200Response> userRegisterPost(UserRegisterPostRequest userRegisterPostRequest) {
        var id = userService.register(userRegisterPostRequest);
        return ResponseEntity.ok(new UserRegisterPost200Response().userId(id));    }
}
