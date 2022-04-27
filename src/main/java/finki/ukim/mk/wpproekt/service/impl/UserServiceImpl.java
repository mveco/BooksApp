package finki.ukim.mk.wpproekt.service.impl;

import finki.ukim.mk.wpproekt.model.Role;
import finki.ukim.mk.wpproekt.model.User;
import finki.ukim.mk.wpproekt.model.exceptions.InvalidUsernameOrPasswordException;
import finki.ukim.mk.wpproekt.model.exceptions.PasswordsDoNotMatchException;
import finki.ukim.mk.wpproekt.model.exceptions.UsernameAlreadyExistsException;
import finki.ukim.mk.wpproekt.repository.UserRepository;
import finki.ukim.mk.wpproekt.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }


    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname,
                         Integer age, String quote, Role userRole) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,passwordEncoder.encode(password),name,surname,age,quote,userRole);
        return userRepository.save(user);
    }
}
