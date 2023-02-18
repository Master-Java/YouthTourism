package ru.skillup.youthtourism.dao;

import ru.skillup.youthtourism.domain.UserDetail;

public interface UserDetailDao {
    void insertUserDetail(UserDetail userDetails);

    void updateUserDetail(UserDetail userDetails);

    UserDetail getUserDetailById(long id);
}
