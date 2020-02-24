package com.example.mediaplayer.repository.repoitorySong;

import com.example.mediaplayer.model.modelArtist.Artist;
import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.model.modelUser.User;
import com.example.mediaplayer.repository.repoitorySong.mapper.SongMapper;
import com.example.mediaplayer.repository.repositoryUser.DAO;
import com.example.mediaplayer.repository.repositoryUser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class SongDAO implements DAO<Song> {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("SONG").usingGeneratedKeyColumns("ID");
    }


    @Override
    public void save(Song song) {
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(song);
        jdbcInsert.execute(parameters);
    }

    @Override
    public Song load(long id) {
        List<Song> songs = jdbcTemplate.query("SELECT * FROM SONG WHERE id =?",
                new Object[]{id}, (resultSet, i) -> {
                    return toSong(resultSet);
                });

        if (songs.size() == 1) {
            return songs.get(0);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM SONG WHERE id = ?", id);
    }

    @Override
    public void update(Song song) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Song> loadAll() {
        return jdbcTemplate.query("SELECT DISTINCT * FROM SONG", (resultSet, i) -> {
            return toSong(resultSet);
        });
    }

    private Song toSong(ResultSet resultSet) throws SQLException {
        Song song = new Song();
        song.setId(resultSet.getLong("ID"));
        song.setSongName(resultSet.getString("SONG_NAME"));
        song.setDateRelease(resultSet.getDate("DATE_OF_RELEASE"));
        song.setLength(resultSet.getLong("LENGTH_OF_SONG"));
        song.setArtist(resultSet.getString("ARTIST"));
        return song;
    }

    public void playedSong(String firstName, String song) {
        String sql = "SELECT SONG_NAME FROM SONG WHERE SONG_NAME = ?" +
                "UNION"
                + " SELECT FROM USER WHERE FIRST_NAME = ?";
        // String sql = "SELECT FROM SONG WHERE SONG_NAME = " + song;
        //String sqlUser = "SELECT FROM USER WHERE FIRST_NAME = " + firstName;
        List<Song> result = jdbcTemplate.query(sql, new SongMapper());
        List<User> resultUser = jdbcTemplate.query(sql, new UserMapper());

    }
}