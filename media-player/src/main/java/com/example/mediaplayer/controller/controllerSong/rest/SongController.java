package com.example.mediaplayer.controller.controllerSong.rest;

import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.model.modelUser.User;
import com.example.mediaplayer.repository.repoitorySong.SongDAO;
import com.example.mediaplayer.repository.repositoryUser.UserDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/songs")
public class SongController {


        private SongDAO songDAO;


        public SongController(SongDAO songDAO) {
            this.songDAO = songDAO;
        }

        @PostMapping
        public void addSong(@RequestBody final Song song) {
            songDAO.save(song);
        }

        @DeleteMapping("/{id}")
        public void deleteSong(@PathVariable final long id) {
            songDAO.delete(id);
        }

        @GetMapping("/{id}")
        public Song getSong(@PathVariable final long id) {
            return songDAO.load(id);
        }

        @GetMapping
        public List<Song> getAllSongs() {
            return songDAO.loadAll();
        }

    @GetMapping("/playedSong")
    public void getSelectedSong(@RequestBody final User user, Song song) {
        songDAO.playedSong(user.getFirstName(), song.getSongName());
    }
        @PutMapping
        public void update(@RequestBody final Song song) {
            songDAO.update(song);
        }
    }



