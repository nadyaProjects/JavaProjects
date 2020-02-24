package com.example.mediaplayer.controller.rest;

import com.example.mediaplayer.model.modelSong.Song;
import com.example.mediaplayer.model.modelUser.User;
import com.example.mediaplayer.repository.repositoryUser.UserDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserDAO userDAO;

    public void UserController(final UserDAO userDAO) {
        this.userDAO = userDAO;

    }

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostMapping
    public void addUser(@RequestBody final User user) {
        userDAO.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable final long id) {
        userDAO.delete(id);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable final long id) {
        return userDAO.load(id);
    }

    @GetMapping("/playedSong")
    public void getSelectedSong(final User user, final Song song) {
        userDAO.playSong(user.getFirstName(), song.getSongName());
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userDAO.loadAll();
    }

    @PutMapping
    public void update(@RequestBody final User user) {
        userDAO.update(user);
    }
}

