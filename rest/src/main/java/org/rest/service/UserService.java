package org.rest.service;

import org.rest.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getUsers();
    User createUser(User user);
    User getUserById(Long userId);
    void updateUserById(Long userId, User user);
    void patchUserById(Long userId, Map<String, Object> updatedFields);
    void deleteUserById(Long userId);

}
