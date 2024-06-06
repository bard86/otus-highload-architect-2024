package ru.otus.dbarsukov.ha.profiles.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.otus.dbarsukov.ha.profiles.dao.UserRepository;
import ru.otus.dbarsukov.ha.profiles.model.UserRegisterPostRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public String register(UserRegisterPostRequest user) {
        return repository.insert(user.getPassword(), user.getFirstName(), user.getSecondName(),
                user.getBirthdate(), user.getCity(), user.getBiography());
    }
}

