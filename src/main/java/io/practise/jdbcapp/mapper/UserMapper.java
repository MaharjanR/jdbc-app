package io.practise.jdbcapp.mapper;

import io.practise.jdbcapp.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setUserName(resultSet.getString("USERNAME"));
        user.setUserPass(resultSet.getString("PASSWORD"));
        user.setCreateDate(resultSet.getDate("CREATE_DATE"));
        return user;
    }
}
