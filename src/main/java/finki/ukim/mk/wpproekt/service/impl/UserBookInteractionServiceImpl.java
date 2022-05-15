package finki.ukim.mk.wpproekt.service.impl;

import finki.ukim.mk.wpproekt.model.Book;
import finki.ukim.mk.wpproekt.model.User;
import finki.ukim.mk.wpproekt.model.UserBookInteraction;
import finki.ukim.mk.wpproekt.model.exceptions.BookNotFoundException;
import finki.ukim.mk.wpproekt.model.exceptions.UserBookInteractionNotFoundException;
import finki.ukim.mk.wpproekt.model.exceptions.UserNotFoundException;
import finki.ukim.mk.wpproekt.repository.BookRepository;
import finki.ukim.mk.wpproekt.repository.UserBookInteractionRepository;
import finki.ukim.mk.wpproekt.repository.UserRepository;
import finki.ukim.mk.wpproekt.service.UserBookInteractionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserBookInteractionServiceImpl implements UserBookInteractionService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final UserBookInteractionRepository userBookInteractionRepository;

    public UserBookInteractionServiceImpl(UserRepository userRepository, BookRepository bookRepository, UserBookInteractionRepository userBookInteractionRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.userBookInteractionRepository = userBookInteractionRepository;
    }

    @Override
    public Optional<UserBookInteraction> create(String username, Integer bookID) {

        User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        Book book = this.bookRepository.findById(bookID).orElseThrow(() -> new BookNotFoundException());

        UserBookInteraction ubi = new UserBookInteraction(user, book);
        return Optional.of(this.userBookInteractionRepository.save(ubi));
    }

    @Override
    public Optional<UserBookInteraction> findById(Integer id) {
        return this.userBookInteractionRepository.findById(id);
    }

    @Override
    public Optional<UserBookInteraction> rate(Integer id, Integer rating) {
        UserBookInteraction ubi = this.userBookInteractionRepository.findById(id).orElseThrow(() -> new UserBookInteractionNotFoundException());
        ubi.setRating(rating);
        return Optional.of(this.userBookInteractionRepository.save(ubi));
    }

    @Override
    public List<UserBookInteraction> findAllByUser(User user) {

        return this.userBookInteractionRepository.findAllByUser(user);
    }

    @Override
    public void deleteById(Integer ID) {
        this.userBookInteractionRepository.deleteById(ID);
    }

}
