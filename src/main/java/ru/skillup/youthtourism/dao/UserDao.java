package ru.skillup.youthtourism.dao;

import ru.skillup.youthtourism.domain.User;

public interface UserDao {
    User getUserByEmail(String email);

    long insertNewUser(User user);

    boolean checkUniqueEmail(String email);

    User getUserById(long id);
}
