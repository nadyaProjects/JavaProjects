package com.example.mediaplayer.controller.controllerSong;

import com.example.mediaplayer.model.modelArtist.Artist;
import com.example.mediaplayer.model.modelSong.CustomerDateAndTimeDeserialize;
import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.repository.repositoryUser.DAO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class SongCreation {
    @Autowired
    DAO<Song> songDao;

    public void process() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date javaDate = sdf.parse("06/07/1989");
        java.sql.Date date = new java.sql.Date(javaDate.getTime());
        Song song = Song.create("Poison", "06/07/1989", 268, "Alice Cooper");
        System.out.println("saving: " + song);
        songDao.save(song);
        Date javaDate1 = sdf.parse("23/08/1989");
        java.sql.Date date1 = new java.sql.Date(javaDate1.getTime());
        song = Song.create("Another Day in Paradise", "23/08/1989", 287, "Phil Collins");
        songDao.save(song);
        Date javaDate2 = sdf.parse("09/06/1999");
        java.sql.Date date2 = new java.sql.Date(javaDate2.getTime());
        song = Song.create("Everything Dies ", "09/06/1999", 463, "Peter Steele");

        System.out.println("saving: " + song);
        songDao.save(song);

        List<Song> list = songDao.loadAll();
        System.out.println("Loaded all: " + list);

    }
}
