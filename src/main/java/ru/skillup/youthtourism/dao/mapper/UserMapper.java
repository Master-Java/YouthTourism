package ru.skillup.youthtourism.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.skillup.youthtourism.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.skillup.youthtourism.utils.JdbcHelper.*;


public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(getLong(rs,"id"))
                .email(getString(rs, "email"))
                .name(getString(rs, "name"))
                .password(getString(rs, "password"))
                .username(getString(rs, "username"))
                .patronymic(getString(rs, "patronymic"))
                .surname(getString(rs, "surname"))
                .confirmation(Boolean.TRUE.equals(getBoolean(rs, "confirmation")))
                .enabled(Boolean.TRUE.equals(getBoolean(rs, "enabled")))
                .build();
    }
}
