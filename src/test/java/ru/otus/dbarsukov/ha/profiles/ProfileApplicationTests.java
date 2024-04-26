package ru.otus.dbarsukov.ha.profiles;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = { "spring.liquibase.enabled=false" })
class ProfileApplicationTests {

    @Test
    void contextLoads() {
    }

}
