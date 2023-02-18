package ru.skillup.youthtourism.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.skillup.youthtourism.dao.AuthoritiesDao;
import ru.skillup.youthtourism.dao.UserDao;
import ru.skillup.youthtourism.dao.UserDetailDao;
import ru.skillup.youthtourism.domain.User;
import ru.skillup.youthtourism.domain.UserDetail;
import ru.skillup.youthtourism.domain.UserDto;
import ru.skillup.youthtourism.service.UserService;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserDetailDao userDetail;
    private final AuthoritiesDao authoritiesDao;

    @Override
    public User getUserByEmail(String email) {
        User user = userDao.getUserByEmail(email);
        user.setRole(authoritiesDao.getRoleByIdUser(user.getId()));
        return user;
    }

    @Override
    public UserDto getUserById(long id) {
        UserDto userDto = convertToUserDto(userDao.getUserById(id));
        userDto.setUserDetail(userDetail.getUserDetailById(id));
        return userDto;
    }

    @Override
    public void insertNewUser(User user) {
        long idNewUser = userDao.insertNewUser(user);
        authoritiesDao.insertRoleForUser(idNewUser, user.getRole());
        userDetail.insertUserDetail(UserDetail.builder().id(idNewUser).build());
    }

    @Override
    public boolean checkUniqueEmail(String email) {
        return userDao.checkUniqueEmail(email);
    }

    private UserDto convertToUserDto(User userById) {
        return UserDto.builder()
                .id(userById.getId())
                .username(userById.getUsername())
                .email(userById.getEmail())
                .name(userById.getName())
                .surname(userById.getSurname())
                .patronymic(userById.getPatronymic())
                .build();
    }
}