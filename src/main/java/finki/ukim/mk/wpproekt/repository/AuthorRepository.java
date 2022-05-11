package finki.ukim.mk.wpproekt.repository;

import finki.ukim.mk.wpproekt.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findByName(String name);
    List<Author> findAllByNameLike(String name);
    void deleteById(Integer id);
    void deleteByName(String name);
}
