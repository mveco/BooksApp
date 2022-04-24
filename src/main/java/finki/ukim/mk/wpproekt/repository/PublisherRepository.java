package finki.ukim.mk.wpproekt.repository;

import finki.ukim.mk.wpproekt.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
