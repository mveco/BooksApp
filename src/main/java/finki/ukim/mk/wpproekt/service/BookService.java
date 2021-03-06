package finki.ukim.mk.wpproekt.service;

import finki.ukim.mk.wpproekt.model.Book;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> create(String title, Float avg_rating, String isbn, String isbn13, String lang_code, Integer num_pages,
                          Integer ratings_count, Integer publisherID, List<Integer> authorsID);

    Optional<Book> update(Integer ID, String title, Float avg_rating, String isbn, String isbn13, String lang_code, Integer num_pages,
                          Integer ratings_count, Integer publisherID, List<Integer> authorsID);

    void delete(Integer ID);

    Optional<Book> getById(Integer ID);

    List<Book> getAll();

    List<Book> getAllByTitle(String title);
}
