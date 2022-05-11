package finki.ukim.mk.wpproekt.service.impl;

import finki.ukim.mk.wpproekt.model.Publisher;
import finki.ukim.mk.wpproekt.model.exceptions.PublisherNotFoundException;
import finki.ukim.mk.wpproekt.repository.PublisherRepository;
import finki.ukim.mk.wpproekt.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Optional<Publisher> create(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();

        }
        this.publisherRepository.deleteByName(name);
        Publisher p = new Publisher(name);
        return Optional.of(this.publisherRepository.save(p));
    }

    @Override
    public Optional<Publisher> update(Integer ID, String name) {
        if (name == null || name.isEmpty() || ID == null) {
            throw new IllegalArgumentException();

        }
        Publisher p = this.publisherRepository.findById(ID)
                .orElseThrow(() -> new PublisherNotFoundException());
        p.setName(name);
        return Optional.of(this.publisherRepository.save(p));
    }

    public void deleteById(Integer ID) {
        this.publisherRepository.deleteById(ID);
    }

    @Override
    public Optional<Publisher> getByName(String name) {

        return this.publisherRepository.findByName(name);
    }

    @Override
    public Optional<Publisher> getById(Integer ID) {

        return this.publisherRepository.findById(ID);
    }

    @Override
    public List<Publisher> getAll() {

        return this.publisherRepository.findAll();
    }

    @Override
    public List<Publisher> getAllByName(String name) {
        return this.publisherRepository.findAllByNameLike('%' + name + '%');
    }
}
