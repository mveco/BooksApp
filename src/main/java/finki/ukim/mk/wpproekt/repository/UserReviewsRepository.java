package finki.ukim.mk.wpproekt.repository;

import finki.ukim.mk.wpproekt.model.UserBookInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewsRepository extends JpaRepository<UserBookInteraction, Integer> {
}
