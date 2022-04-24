package finki.ukim.mk.wpproekt.repository;

import finki.ukim.mk.wpproekt.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
