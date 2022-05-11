package finki.ukim.mk.wpproekt.service;

import finki.ukim.mk.wpproekt.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> create(String name);
    Optional<Author> update(Integer ID, String name);
    void deleteById(Integer ID);

    Optional<Author> getByName(String name);
    Optional<Author> getById(Integer ID);

    List<Author> getAll();
    List<Author> getAllByName(String name);
}
