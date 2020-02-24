package com.example.mediaplayer.repository.repoitorySong.mapper;

import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.model.modelUser.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SongMapper implements RowMapper<Song> {
    @Override
    public Song mapRow(ResultSet rs, int i) throws SQLException {

        final Song song = new Song();
        song.setSongName(rs.getString("SONG_NAME"));
        song.setArtist(rs.getString("ARTIST"));
        song.setLength(rs.getLong("Length"));
        song.setDateRelease(rs.getDate("DATE_OF_RELEASE"));
        song.setId(rs.getLong("ID"));
        return song;


    }
}
