package finki.ukim.mk.wpproekt.repository;

import finki.ukim.mk.wpproekt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
