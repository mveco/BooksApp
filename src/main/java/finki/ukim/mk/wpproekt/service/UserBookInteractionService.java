package finki.ukim.mk.wpproekt.service;

import finki.ukim.mk.wpproekt.model.Book;
import finki.ukim.mk.wpproekt.model.User;
import finki.ukim.mk.wpproekt.model.UserBookInteraction;

import java.util.List;
import java.util.Optional;

public interface UserBookInteractionService {

    Optional<UserBookInteraction> create(String username, Integer book, boolean read_flag,
                       boolean reading_list, boolean like, Integer rating, String reviewText);

    Optional<UserBookInteraction> update(Integer id, String username, Integer book, boolean read_flag,
                                         boolean reading_list, boolean like, Integer rating, String reviewText);

    void deleteById(Integer ID);


    List<UserBookInteraction> getAllInReadingList();



}
