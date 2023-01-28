package com.example.wsbp.repository;

import com.example.wsbp.data.AuthUser;
import com.example.wsbp.data.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthUserRepository implements IAuthUserRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public AuthUserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int insert(String userName, String userPass) {
        var sql = "insert into auth_user values (?, ?)";
        var n = jdbc.update(sql, userName, userPass);
        return n;
    }

    @Override
    public int delete(String userName) {
        var sql = "delete from auth_user where user_name = ?";
        var n = jdbc.update(sql, userName);
        return n;
    }

    @Override
    public boolean exists(String userName, String userPass) {
        var sql = "select true from auth_user " +
                "where user_name = ? and user_pass = ?";

        var booles = jdbc.query(sql,
                new SingleColumnRowMapper(Boolean.class),
                new Object[]{userName, userPass});

        return !booles.isEmpty();
    }

    @Override
    public List<AuthUser> find() {
        String sql = "select user_name, user_pass from auth_user";

        List<AuthUser> users = jdbc.query(sql,
                new BeanPropertyRowMapper<>(AuthUser.class),
                new Object[]{});

        return users;
    }

    @Override
    public int insertMassage(String userName, String userMsg) {
        var sql = "insert into chat values (?, ?)";
        var n = jdbc.update(sql, userName, userMsg);
        return n;
    }

    @Override
    public List<Chat> findMassage() {
        var sql = "select user_name, msg_body from chat";

        List<Chat> msgs = jdbc.query(sql,
                new BeanPropertyRowMapper<>(Chat.class),
                new Object[]{});

        return msgs;
    }

}
