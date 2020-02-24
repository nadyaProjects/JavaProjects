package com.example.mediaplayer.controller.controllerArtist.rest;

import com.example.mediaplayer.model.modelArtist.Artist;
import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.repository.repoitorySong.SongDAO;
import com.example.mediaplayer.repository.repositoryArtist.ArtistDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {


    private ArtistDAO artistDAO;


    public ArtistController(ArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    @PostMapping
    public void addArtist(@RequestBody final Artist artist) {
        artistDAO.save(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable final long id) {
        artistDAO.delete(id);
    }

    @GetMapping("/{id}")
    public Artist getSong(@PathVariable final long id) {
        return artistDAO.load(id);
    }

    @GetMapping
    public List<Artist> getAllSongs() {
        return artistDAO.loadAll();
    }

    @PutMapping
    public void update(@RequestBody final Artist artist) {
        artistDAO.update(artist);
    }

}





