package ru.skillup.youthtourism.dao;

import ru.skillup.youthtourism.domain.Role;

public interface AuthoritiesDao {
    void insertRoleForUser(long id, Role role);

    Role getRoleByIdUser(long id);
}
