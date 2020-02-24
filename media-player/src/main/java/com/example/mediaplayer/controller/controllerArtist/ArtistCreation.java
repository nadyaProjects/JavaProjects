package com.example.mediaplayer.controller.controllerArtist;

import com.example.mediaplayer.model.modelArtist.Artist;
import com.example.mediaplayer.repository.repositoryUser.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistCreation {
    @Autowired
    DAO<Artist> artistDao;

    public void process() {


        Artist artist = Artist.create("Phil", "Collins", "1951-01-30", "classic rock", "Phil Collins");
        System.out.println("saving: " + artist);
        artistDao.save(artist);

        artist = Artist.create("Alice", "Cooper", "1948-02-04", "rock", "Alice Cooper");
        artistDao.save(artist);

        artist = Artist.create("Peter", "Steele", "1962-01-04", "doom,metal", "Peter Steele");

        System.out.println("saving: " + artist);
        artistDao.save(artist);

        List<Artist> list = artistDao.loadAll();
        System.out.println("Loaded all: " + list);

    }
}
