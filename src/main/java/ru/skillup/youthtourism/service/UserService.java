package ru.skillup.youthtourism.service;

import ru.skillup.youthtourism.domain.User;
import ru.skillup.youthtourism.domain.UserDto;

public interface UserService {
    User getUserByEmail(String email);

    UserDto getUserById(long id);

    void insertNewUser(User user);

    boolean checkUniqueEmail(String email);
}
