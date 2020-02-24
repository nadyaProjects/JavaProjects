package com.example.mediaplayer.repository.repositoryArtist.mapper;

import com.example.mediaplayer.model.modelArtist.Artist;
import com.example.mediaplayer.model.modelUser.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistMapper implements RowMapper<Artist> {
    @Override
    public Artist mapRow(ResultSet rs, int i) throws SQLException {
        final Artist artist = new Artist();
        artist.setFirstName(rs.getString("FIRST_NAME"));
        artist.setLastName(rs.getString("LAST_NAME"));
        artist.setGenre(rs.getString("GENRE"));
        artist.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
        artist.setId(rs.getLong("ID"));
        artist.setArtistName("ARTIST_NAME");
        return artist;
    }
}
