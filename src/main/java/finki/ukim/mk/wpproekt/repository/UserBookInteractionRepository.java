package finki.ukim.mk.wpproekt.repository;

import finki.ukim.mk.wpproekt.model.User;
import finki.ukim.mk.wpproekt.model.UserBookInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserBookInteractionRepository extends JpaRepository<UserBookInteraction, Integer> {

    List<UserBookInteraction> findAllByUser(User user);
}
