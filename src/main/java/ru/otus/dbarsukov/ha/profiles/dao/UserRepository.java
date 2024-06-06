package ru.otus.dbarsukov.ha.profiles.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private static final String INSERT_SQL =
            "INSERT INTO public.users (password, first_name, last_name, birthdate, city, biography) " +
                    "VALUES (?, ?, ?, ?, ?, ?)" +
                    "RETURNING id";

    private final JdbcTemplate jdbcTemplate;

    public String insert(String password, String firstName, String lastName,
                       LocalDate birthdate, String city, String biography) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(INSERT_SQL, new String[]{"id"});
            int idx = 1;
            ps.setString(idx++, password);
            ps.setString(idx++, firstName);
            ps.setString(idx++, lastName);
            ps.setDate(idx++, Date.valueOf(birthdate));
            ps.setString(idx++, city);
            ps.setString(idx, biography);
            return ps;
        }, keyHolder);
        return String.valueOf(keyHolder.getKeyList().get(0).get("id"));
    }
}
