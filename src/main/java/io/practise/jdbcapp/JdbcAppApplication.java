package io.practise.jdbcapp;

import io.practise.jdbcapp.dao.UserDao;
import io.practise.jdbcapp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class JdbcAppApplication {

    UserDao userDao;

    public JdbcAppApplication(UserDao userDao) {
        this.userDao = userDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(JdbcAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(){
        return (args) -> {
            User user = new User(1, "Ritesh", "pass123", new Date());
            User user2 = new User(2, "Gkes", "pass123", new Date());
            userDao.createUser(user);
            userDao.createUser(user2);
            userDao.updateUserName(new User(2, "Bipash", "pass123", new Date()));
            System.out.println(userDao.getUser(1));
            System.out.println(userDao.getAllUser());
            userDao.deleteUser(2);
            System.out.println(userDao.getAllUser());

        };
    }
}
