package ru.skillup.youthtourism.dao.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import ru.skillup.youthtourism.dao.UserDao;
import ru.skillup.youthtourism.dao.mapper.UserMapper;
import ru.skillup.youthtourism.domain.User;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserDaoJdbcImpl implements UserDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public User getUserById(long id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), new UserMapper());
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = :email";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("email", email), new UserMapper());
    }

    @Override
    public long insertNewUser(User user) {
        String sql = """
                INSERT INTO users (username, password, email, name, surname, patronymic)
                VALUES (:username, :password, :email, :name, :surname, :patronymic);
                """;
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, getMapSqlParameterSource(user), generatedKeyHolder, new String[]{"id"});
        return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();
    }

    @Override
    public boolean checkUniqueEmail(String email) {
        String sql = "SELECT COUNT(*) FROM users where email = :email AND enabled = TRUE";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("email", email), Long.class) == 0;
    }

    private MapSqlParameterSource getMapSqlParameterSource(User user) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("username", user.getUsername());
        param.addValue("password", user.getPassword());
        param.addValue("email", user.getEmail());
        param.addValue("name", user.getName());
        param.addValue("surname", user.getSurname());
        param.addValue("patronymic", user.getPatronymic());
        return param;
    }
}
