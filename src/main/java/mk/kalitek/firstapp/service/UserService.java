package mk.kalitek.firstapp.service;

import mk.kalitek.firstapp.domain.User;
import mk.kalitek.firstapp.exception.domain.EmailExistException;
import mk.kalitek.firstapp.exception.domain.UserNotFoundException;
import mk.kalitek.firstapp.exception.domain.UsernameExistException;

import java.util.List;

public interface UserService {
    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, EmailExistException, UsernameExistException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
}
