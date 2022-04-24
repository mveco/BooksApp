package finki.ukim.mk.wpproekt.repository;


import finki.ukim.mk.wpproekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

