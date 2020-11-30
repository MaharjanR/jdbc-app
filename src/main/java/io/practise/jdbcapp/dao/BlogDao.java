package io.practise.jdbcapp.dao;

import io.practise.jdbcapp.domain.Blog;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
@AllArgsConstructor
public class BlogDao {
    private UserDao userDao;

    public NamedParameterJdbcTemplate namedTemplate;


    public Blog createBlog(Blog blog){
        String sql =
                "INSERT INTO BLOG VALUES(:userId, :blogName,:blogCategory,:blogText)";
        SqlParameterSource source = new BeanPropertySqlParameterSource(blog);
        namedTemplate.update(sql, source);
        return blog;
    }
}
