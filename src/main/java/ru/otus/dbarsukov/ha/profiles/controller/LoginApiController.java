package ru.otus.dbarsukov.ha.profiles.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.dbarsukov.ha.profiles.api.LoginApi;
import ru.otus.dbarsukov.ha.profiles.model.LoginPost200Response;
import ru.otus.dbarsukov.ha.profiles.model.LoginPostRequest;

@Controller
@RequestMapping("${application.base-path}")
public class LoginApiController implements LoginApi {
    @Override
    public ResponseEntity<LoginPost200Response> loginPost(LoginPostRequest loginPostRequest) {
        return null;
    }
}
