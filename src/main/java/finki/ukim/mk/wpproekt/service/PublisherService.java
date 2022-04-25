package finki.ukim.mk.wpproekt.service;

import finki.ukim.mk.wpproekt.model.Author;
import finki.ukim.mk.wpproekt.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {

    Optional<Publisher> create(String name);
    Optional<Publisher> update(Integer ID, String name);
    void delete(Integer ID);

    Optional<Publisher> getByName(String name);
    Optional<Publisher> getById(Integer ID);

    List<Publisher> getAll();
    List<Publisher> getAllByName(String name);
}
