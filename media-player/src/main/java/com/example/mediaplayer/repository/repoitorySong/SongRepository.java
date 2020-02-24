package com.example.mediaplayer.repository.repoitorySong;

import com.example.mediaplayer.model.modelArtist.Artist;
import com.example.mediaplayer.model.modelSong.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class SongRepository implements CrudRepository<Song, Integer> {
    @Override
    public <S extends Song> S save(S s) {
        return null;
    }

    @Override
    public <S extends Song> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Song> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Song> findAll() {
        return null;
    }

    @Override
    public Iterable<Song> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Song song) {

    }

    @Override
    public void deleteAll(Iterable<? extends Song> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
