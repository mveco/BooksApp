package finki.ukim.mk.wpproekt.service;

import finki.ukim.mk.wpproekt.model.Role;
import finki.ukim.mk.wpproekt.model.User;

public interface AuthService {
    User login(String username, String password);
}
