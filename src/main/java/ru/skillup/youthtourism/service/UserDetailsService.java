package ru.skillup.youthtourism.service;

import ru.skillup.youthtourism.domain.UserDetail;

public interface UserDetailsService {
    void insertUserDetail(UserDetail userDetails);

    void updateUserDetail(UserDetail userDetails);

    UserDetail getUserDetailById(long id);
}
