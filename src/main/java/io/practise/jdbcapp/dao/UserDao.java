package io.practise.jdbcapp.dao;

import io.practise.jdbcapp.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserDao {

    public JdbcTemplate template;

    public UserDao(JdbcTemplate template) {
        this.template = template;
        this.createTable();
    }

    public void createTable(){
        log.info("Creating table User");
        template.execute("CREATE TABLE USER " +
                "USER_ID INT " +
                "USERNAME CHAR(25)" +
                "PASSWORD CHAR(25)" +
                "CREATE_DATE DATE ");
    }

    public User createUser(User user){
        String sql = "INSERT USER VALUES(?, ?, ?, ?)";
        template.update(sql, new Object[] { user.getId(), user.getUserName(), user.getUserPass(), user.getCreateDate()});
        return user;
    }
}