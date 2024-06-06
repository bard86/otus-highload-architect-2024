package ru.otus.dbarsukov.ha.profiles.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.otus.dbarsukov.ha.profiles.model.User;
import ru.otus.dbarsukov.ha.profiles.model.UserRegisterPost200Response;
import ru.otus.dbarsukov.ha.profiles.model.UserRegisterPostRequest;

@Controller
@RequestMapping("${application.base-path}/user")
public class UserApiController implements UserApi {
    @Override
    public ResponseEntity<User> userGetIdGet(String id) {
        return null;
    }

    @Override
    public ResponseEntity<UserRegisterPost200Response> userRegisterPost(UserRegisterPostRequest userRegisterPostRequest) {
        return null;
    }
}
