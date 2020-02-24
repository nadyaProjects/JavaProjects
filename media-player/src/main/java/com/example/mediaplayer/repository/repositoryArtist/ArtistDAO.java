package com.example.mediaplayer.repository.repositoryArtist;

import com.example.mediaplayer.model.modelArtist.Artist;
import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.model.modelUser.User;
import com.example.mediaplayer.repository.repoitorySong.mapper.SongMapper;
import com.example.mediaplayer.repository.repositoryArtist.mapper.ArtistMapper;
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
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ArtistDAO implements DAO<Artist> {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;

    @PostConstruct
    private void postConstruct() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("ARTIST").usingGeneratedKeyColumns("ID");
    }

    @Override
    public void save(Artist artist) {
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(artist);
        jdbcInsert.execute(parameters);
    }

    @Override
    public Artist load(long id) {
        List<Artist> artists = jdbcTemplate.query("SELECT DISTINCT * FROM ARTIST WHERE id =?",
                new Object[]{id}, (resultSet, i) -> {
                    return toArtist(resultSet);
                });

        if (artists.size() == 1) {
            return artists.get(0);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM ARTIST WHERE id = ?", id);
    }

    @Override
    public void update(Artist artist) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Artist> loadAll() {
        return jdbcTemplate.query("SELECT DISTINCT * FROM ARTIST", (resultSet, i) -> {
            return toArtist(resultSet);
        });
    }

    private Artist toArtist(ResultSet resultSet) throws SQLException {
        Artist artist = new Artist();
        artist.setId(resultSet.getLong("ID"));
        artist.setFirstName(resultSet.getString("FIRST_NAME"));
        artist.setLastName(resultSet.getString("LAST_NAME"));
        artist.setDateOfBirth(resultSet.getDate("DATE_OF_BIRTH"));
        artist.setGenre(resultSet.getString("GENRE"));
        return artist;
    }

    public void createTable() {
        jdbcTemplate.execute("DROP TABLE artist IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE artist(" +
                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
    }

    public void addSong(String artist, String song) {
        String s = "'" + artist + "'";
        String u = "'" + song + "'";

        String sql = "INSERT INTO song (song_name = \" + u + \" ) "
                + " SELECT artist.artist_name FROM artist  INNER JOIN song  ON  song.artist = artist.artist_name"
                + " WHERE artist.artist_name=" + s;


        List<Song> result = jdbcTemplate.query(sql, new SongMapper());
        List<Artist> resultUser = jdbcTemplate.query(sql, new ArtistMapper());
        System.out.println(song + " is added.");

    }

    public void deleteSong(String artist, String song) {
        String s = '"' + artist + '"';
        String u = '"' + song + '"';
        String sql = "DELETE FROM song "
                + " WHERE song_name = " + u
                + " AND artist =" + s;

        List<Song> result = jdbcTemplate.query(sql, new SongMapper());
        List<Artist> resultUser = jdbcTemplate.query(sql, new ArtistMapper());
        System.out.println(song + " is deleted.");
    }

    public void updateSong(String artist, String song) {

        String s = '"' + artist + '"';
        String u = '"' + song + '"';

        String sql = "UPDATE song "
                + " SET song_name =" + u
                + " WHERE artist = " + s;
        //  sql = sql.replace("%20"," ");


        List<Song> result = jdbcTemplate.query(sql, new SongMapper());
        List<Artist> resultUser = jdbcTemplate.query(sql, new ArtistMapper());
        System.out.println(song + " is updated.");
    }
}