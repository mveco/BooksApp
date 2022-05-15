package finki.ukim.mk.wpproekt.service.impl;

import finki.ukim.mk.wpproekt.model.Author;
import finki.ukim.mk.wpproekt.model.Book;
import finki.ukim.mk.wpproekt.model.Publisher;
import finki.ukim.mk.wpproekt.model.exceptions.BookNotFoundException;
import finki.ukim.mk.wpproekt.model.exceptions.PublisherNotFoundException;
import finki.ukim.mk.wpproekt.repository.AuthorRepository;
import finki.ukim.mk.wpproekt.repository.BookRepository;
import finki.ukim.mk.wpproekt.repository.PublisherRepository;
import finki.ukim.mk.wpproekt.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Book> create(String title, Float avg_rating, String isbn, String isbn13, String lang_code,
                                 Integer num_pages, Integer ratings_count, Integer publisherID,
                                 List<Integer> authorsID) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Publisher publisher = this.publisherRepository.findById(publisherID).orElseThrow(() -> new PublisherNotFoundException());
        List<Author> authors = this.authorRepository.findAllById(authorsID);

        this.bookRepository.deleteByTitle(title);
        Book b = new Book(title, avg_rating, isbn, isbn13, lang_code, num_pages, ratings_count,
                publisher, authors);
        return Optional.of(this.bookRepository.save(b));
    }

    @Override
    public Optional<Book> update(Integer ID, String title, Float avg_rating, String isbn, String isbn13, String lang_code,
                                 Integer num_pages, Integer ratings_count, Integer publisherID, List<Integer> authorsID) {
        if (title == null || title.isEmpty() || ID == null) {
            throw new IllegalArgumentException();
        }
        Publisher publisher = this.publisherRepository.findById(publisherID).orElseThrow(() -> new PublisherNotFoundException());
        List<Author> authors = this.authorRepository.findAllById(authorsID);

        Book b = this.bookRepository.findById(ID).orElseThrow(() -> new BookNotFoundException());
        b.setTitle(title);
        b.setAvg_rating(avg_rating);
        b.setIsbn(isbn);
        b.setIsbn13(isbn13);
        b.setLang_code(lang_code);
        b.setNum_pages(num_pages);
        b.setRatings_count(ratings_count);
        b.setPublisher(publisher);
        b.setAuthors(authors);

        return Optional.of(this.bookRepository.save(b));
    }

    @Override
    public void delete(Integer ID) {
        this.bookRepository.deleteById(ID);
    }

    @Override
    public Optional<Book> getById(Integer ID) {
        return this.bookRepository.findById(ID);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> getAllByTitle(String title) {
        return this.bookRepository.findAllByTitleLike('%' + title + '%');
    }
}
