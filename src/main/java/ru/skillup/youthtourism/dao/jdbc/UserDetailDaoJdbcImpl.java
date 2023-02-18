package ru.skillup.youthtourism.dao.jdbc;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.skillup.youthtourism.dao.UserDetailDao;
import ru.skillup.youthtourism.dao.mapper.UserDetailsMapper;
import ru.skillup.youthtourism.domain.UserDetail;

@Component
@AllArgsConstructor
public class UserDetailDaoJdbcImpl implements UserDetailDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void insertUserDetail(UserDetail userDetails) {
        String sql = """
                INSERT INTO user_details (id, phone, city, university, interests)
                VALUES (:id, :phone, :city, :university, :interests);
                """;
        jdbcTemplate.update(sql, getParamSource(userDetails));
    }

    private MapSqlParameterSource getParamSource(UserDetail userDetails) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id", userDetails.getId());
        mapSqlParameterSource.addValue("phone", userDetails.getPhone());
        mapSqlParameterSource.addValue("city", userDetails.getCity());
        mapSqlParameterSource.addValue("university", userDetails.getUniversity());
        mapSqlParameterSource.addValue("interests", userDetails.getInterests());
        return mapSqlParameterSource;
    }

    @Override
    public void updateUserDetail(UserDetail userDetails) {
        String sql = """
                UPDATE user_details SET phone = :phone, city = :city, university = :university, interests = :interests
                WHERE id = :id;
                """;
        jdbcTemplate.update(sql, getParamSource(userDetails));
    }

    @Override
    public UserDetail getUserDetailById(long id) {
        String sql = "SELECT * FROM user_details WHERE id = :id;";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id",id), new UserDetailsMapper());
    }
}