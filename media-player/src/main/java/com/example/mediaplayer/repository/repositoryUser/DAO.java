package com.example.mediaplayer.repository.repositoryUser;

import java.util.List;

public interface DAO<T> {
    void save(T t);

    T load(long id);

    void delete(long id);

    void update(T t);

    List<T> loadAll();
}
