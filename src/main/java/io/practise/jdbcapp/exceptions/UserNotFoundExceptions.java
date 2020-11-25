package io.practise.jdbcapp.exceptions;

public class UserNotFoundExceptions extends RuntimeException {

    public UserNotFoundExceptions(String msg){
        super(msg);
    }
}
