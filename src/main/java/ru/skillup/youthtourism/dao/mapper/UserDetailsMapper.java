package ru.skillup.youthtourism.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.skillup.youthtourism.domain.UserDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

import static ru.skillup.youthtourism.utils.JdbcHelper.getLong;
import static ru.skillup.youthtourism.utils.JdbcHelper.getString;

public class UserDetailsMapper implements RowMapper<UserDetail> {
    @Override
    public UserDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UserDetail.builder()
                .id(getLong(rs,"id"))
                .interests(getString(rs, "interests"))
                .city(getString(rs, "city"))
                .university(getString(rs, "university"))
                .phone(getString(rs, "phone"))
                .build();
    }
}
