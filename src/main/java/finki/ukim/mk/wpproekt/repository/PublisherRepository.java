package finki.ukim.mk.wpproekt.repository;

import finki.ukim.mk.wpproekt.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    Optional<Publisher> findByName(String name);

    List<Publisher> findAllByNameLike(String name);

    void deleteByName(String name);

    void deleteByID(Integer ID);
}
