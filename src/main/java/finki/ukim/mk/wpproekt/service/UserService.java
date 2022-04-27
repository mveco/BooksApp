package finki.ukim.mk.wpproekt.service;


import finki.ukim.mk.wpproekt.model.Role;
import finki.ukim.mk.wpproekt.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    User register(String username, String password,
                  String repeatPassword, String name, String surname, Integer age, String quote, Role role);
}
