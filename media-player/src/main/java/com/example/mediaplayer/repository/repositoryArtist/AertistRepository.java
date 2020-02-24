package com.example.mediaplayer.repository.repositoryArtist;

import com.example.mediaplayer.model.modelArtist.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class AertistRepository implements CrudRepository<Artist, Integer> {
    @Override
    public <S extends Artist> S save(S s) {
        return null;
    }

    @Override
    public <S extends Artist> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Artist> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Artist> findAll() {
        return null;
    }

    @Override
    public Iterable<Artist> findAllById(Iterable<Integer> iterable) {
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
    public void delete(Artist artist) {

    }

    @Override
    public void deleteAll(Iterable<? extends Artist> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
