package ru.skillup.youthtourism.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.skillup.youthtourism.dao.UserDetailDao;
import ru.skillup.youthtourism.domain.UserDetail;
import ru.skillup.youthtourism.service.UserDetailsService;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDetailDao userDetailsDao;

    @Override
    public void insertUserDetail(UserDetail userDetails) {
        userDetailsDao.insertUserDetail(userDetails);
    }

    @Override
    public void updateUserDetail(UserDetail userDetails) {
        userDetailsDao.updateUserDetail(userDetails);
    }

    @Override
    public UserDetail getUserDetailById(long id) {
        return userDetailsDao.getUserDetailById(id);
    }
}
