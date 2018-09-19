package cn.xuyue.firstshiro.service.impl;

import cn.xuyue.firstshiro.service.UserService;
import cn.xuyue.firstshiro.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getPassword(String username) {
        String sql = "SELECT * FROM user WHERE name = ?";
        List<User> list = jdbcTemplate.query(sql, new Object[]{},
                new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setPassword(resultSet.getString(3));
                return u;
            }
        });

        if (list == null || list.size() == 0) {
            return null;
        }

        return list.get(0).getPassword();
    }

    @Override
    public String getSalt(String username) {
        String sql = "SELECT * FROM user WHERE name = ?";
        List<User> list = jdbcTemplate.query(sql, new Object[]{},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User u = new User();
                        u.setPassword(resultSet.getString(4));
                        return u;
                    }
                });

        if (list == null || list.size() == 0) {
            return null;
        }

        return list.get(0).getSalt();
    }
}
