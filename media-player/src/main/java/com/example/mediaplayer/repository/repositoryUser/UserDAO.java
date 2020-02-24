package com.example.mediaplayer.repository.repositoryUser;

import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.model.modelUser.User;
import com.example.mediaplayer.repository.repoitorySong.mapper.SongMapper;
import com.example.mediaplayer.repository.repositoryUser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAO implements DAO<User> {
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("USER").usingGeneratedKeyColumns("ID");
    }

    @Override
    public void save(User user) {
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
        jdbcInsert.execute(parameters);
    }

    @Override
    public User load(long id) {
        List<User> users = jdbcTemplate.query("SELECT DISTINCT * FROM USER WHERE id =?",
                new Object[]{id}, (resultSet, i) -> {
                    return toUser(resultSet);
                });

        if (users.size() == 1) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM USER WHERE id = ?", id);
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> loadAll() {
        return jdbcTemplate.query("SELECT * FROM USER", (resultSet, i) -> {
            return toUser(resultSet);
        });
    }

    private User toUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("ID"));
        user.setFirstName(resultSet.getString("FIRST_NAME"));
        user.setLastName(resultSet.getString("LAST_NAME"));
        user.setEmail(resultSet.getString("EMAIL"));
        user.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"));
        user.setPaid(resultSet.getBoolean("PAID"));
        return user;
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void playSong(String firstName, String song) {
        String s = '"' + firstName + '"';
        String u = '"' + firstName + '"';
        String sql = "SELECT user.first_name," +
                "song.song_name " +
                "FROM user,song "
                + "WHERE user.first_name = " + s
                + " AND song.song_name =" + u + ";";

        List<Song> result = jdbcTemplate.query(sql, new SongMapper());
        List<User> resultUser = jdbcTemplate.query(sql, new UserMapper());
        System.out.println("Playing " + song);


    }


}

