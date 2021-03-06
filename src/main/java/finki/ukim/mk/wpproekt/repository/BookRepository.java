package finki.ukim.mk.wpproekt.repository;

import finki.ukim.mk.wpproekt.model.Book;
import finki.ukim.mk.wpproekt.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> deleteByTitle(String title);
    Optional<Book> findByTitleLike(String title);

    List<Book> findAllByTitleLike(@Param("title") String title);
}
