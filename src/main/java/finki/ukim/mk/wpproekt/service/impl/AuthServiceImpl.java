package finki.ukim.mk.wpproekt.service.impl;

import finki.ukim.mk.wpproekt.model.Role;
import finki.ukim.mk.wpproekt.model.User;
import finki.ukim.mk.wpproekt.model.exceptions.InvalidArgumentsException;
import finki.ukim.mk.wpproekt.model.exceptions.InvalidUserCredentialsException;
import finki.ukim.mk.wpproekt.repository.UserRepository;
import finki.ukim.mk.wpproekt.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }


}
