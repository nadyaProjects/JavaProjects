package com.example.mediaplayer.controller.controllerArtist;

import com.example.mediaplayer.model.modelArtist.Artist;
import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.repository.repositoryArtist.ArtistDAO;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/artistsActions")
public class ActionsController {

    private ArtistDAO artistDAO;
    public ActionsController(ArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

    @PostMapping
    public void addSong(@RequestBody final Artist artist, final Song song) {
        artistDAO.addSong(song.getArtist(), song.getSongName());
    }

    @DeleteMapping
    public void deleteSong(final Song artist, final Song song) {
        artistDAO.deleteSong(song.getArtist(), song.getSongName());
    }

    @PutMapping
    public void updateSong(@RequestBody final Song artist, final Song song) {
        artistDAO.updateSong(song.getArtist(), song.getSongName());
    }
}
