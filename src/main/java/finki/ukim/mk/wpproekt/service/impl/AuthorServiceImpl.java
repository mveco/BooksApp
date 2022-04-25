package finki.ukim.mk.wpproekt.service.impl;

import finki.ukim.mk.wpproekt.model.Author;
import finki.ukim.mk.wpproekt.model.exceptions.AuthorNotFoundException;
import finki.ukim.mk.wpproekt.repository.AuthorRepository;
import finki.ukim.mk.wpproekt.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> create(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();

        }
        this.authorRepository.deleteByName(name);
        Author a = new Author(name);
        return Optional.of(this.authorRepository.save(a));
    }

    @Override
    public Optional<Author> update(Integer ID, String name) {
        if (name == null || name.isEmpty() || ID == null) {
            throw new IllegalArgumentException();

        }
        Author a = authorRepository.findById(ID)
                .orElseThrow(() -> new AuthorNotFoundException());
        a.setName(name);
        return Optional.of(this.authorRepository.save(a));
    }

    @Override
    public void delete(Integer ID) {

        this.authorRepository.deleteById(ID);
    }

    @Override
    public Optional<Author> getByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public Optional<Author> getById(Integer ID) {
        return authorRepository.findById(ID);
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAllByName(String name) {
        return authorRepository.findAllByNameLike(name);
    }
}
