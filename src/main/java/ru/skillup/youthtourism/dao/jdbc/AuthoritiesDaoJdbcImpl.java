package ru.skillup.youthtourism.dao.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.skillup.youthtourism.dao.AuthoritiesDao;
import ru.skillup.youthtourism.domain.Role;

@Component
@RequiredArgsConstructor
public class AuthoritiesDaoJdbcImpl implements AuthoritiesDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insertRoleForUser(long id, Role role) {
        String sql = """
                INSERT INTO role (id, role)
                VALUES (:id, :role);
                """;
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("role", role.name());
        jdbcTemplate.update(sql, paramSource);
    }

    @Override
    public Role getRoleByIdUser(long id) {
        String sql = "SELECT role FROM role WHERE id = :id";
        return Role.valueOf(jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", id), String.class));
    }
}
