package finki.ukim.mk.wpproekt.service;

import finki.ukim.mk.wpproekt.model.Author;
import finki.ukim.mk.wpproekt.model.Book;
import finki.ukim.mk.wpproekt.model.Publisher;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookService{

    Optional<Book> create(String title, Float avg_rating, String isbn, String isbn13, String lang_code, Integer num_pages,
                          Integer ratings_count, Date publication_date, Integer publisherID, List<Integer> authorsID);
    Optional<Book> update(Integer ID, String title, Float avg_rating, String isbn, String isbn13, String lang_code, Integer num_pages,
                          Integer ratings_count, Date publication_date, Integer publisherID, List<Integer> authorsID);
    void delete(Integer ID);

    Optional<Book> getByTitle(String title);
    Optional<Book> getById(Integer ID);

    List<Book> getAll();
    List<Book> getAllByTitle(String title);
}
