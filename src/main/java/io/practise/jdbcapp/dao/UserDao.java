package io.practise.jdbcapp.dao;

import io.practise.jdbcapp.domain.User;
import io.practise.jdbcapp.exceptions.UserNotFoundExceptions;
import io.practise.jdbcapp.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        template.execute("CREATE TABLE USER ( USER_ID INT, USERNAME CHAR(20), PASSWORD CHAR(20), CREATE_DATE DATE )");
    }

    public User createUser(User user){
        String sql = "INSERT INTO USER VALUES(?, ?, ?, ?)";
        template.update(sql, new Object[] { user.getId(), user.getUserName(), user.getUserPass(), user.getCreateDate()});
        return user;
    }

    public User updateUserName(User user){
        String sql = "UPDATE USER SET USERNAME = ? WHERE USER_ID = ?";
        template.update(sql, new Object[]{ user.getUserName(), user.getId() });
        return user;
    }

    public User getUser(int userId){
        String sql = "SELECT * FROM USER WHERE USER_ID = ?";
        return this.template.queryForObject(sql, new Object[]{userId}, new UserMapper());
    }

    public List<User> getAllUser(){
        String sql = "SELECT * FROM USER";
        List<User> users = template.query(sql, new UserMapper());
        return users;
    }

    public void deleteUser(int userId){
        log.info("Deleting table user of User id " + userId);
        String sql = "DELETE FROM USER WHERE USER_ID = ?";
        int update = template.update(sql, new Object[] {userId});

        if(update==0){
            log.error("User ID {} doesnt exists in the database",userId);
            throw new UserNotFoundExceptions("No such User found");
        }
    }
}
