package com.example.mediaplayer.repository.repositoryUser.mapper;

import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.model.modelUser.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {

               final User user = new User();
                user.setFirstName(rs.getString("FIRST_NAME"));
                user.setLastName(rs.getString("LAST_NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
                user.setId(rs.getInt("ID"));
                user.setPaid(rs.getBoolean("PAID"));
                return user;


            }

        }

