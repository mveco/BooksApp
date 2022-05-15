package finki.ukim.mk.wpproekt.service;

import finki.ukim.mk.wpproekt.model.Book;
import finki.ukim.mk.wpproekt.model.User;
import finki.ukim.mk.wpproekt.model.UserBookInteraction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserBookInteractionService {

    Optional<UserBookInteraction> create(String username, Integer book);

    Optional<UserBookInteraction> update(Integer id, String username, Integer book, boolean read_flag,
                                         Integer rating, String reviewText);

    Optional<UserBookInteraction> findById(Integer id);

    Optional<UserBookInteraction> read(Integer id);

    Optional<UserBookInteraction> rate(Integer id, Integer rating);

    List<UserBookInteraction> findAllByUser(User user);

    void deleteById(Integer ID);

    List<UserBookInteraction> getAllInReadingList();

}
