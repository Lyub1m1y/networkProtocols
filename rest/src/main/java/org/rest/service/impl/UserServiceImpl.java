package org.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.rest.entity.User;
import org.rest.repository.UserRepository;
import org.rest.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void updateUserById(Long userId, User user) {
        user.setId(userId);
        userRepository.save(user);
    }

    @Override
    public void patchUserById(Long userId, Map<String, Object> updatedFields) {
        User originalUser = getUserById(userId);
        userRepository.save(getPatchedUser(originalUser, updatedFields));
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    private User getPatchedUser(User originalUser, Map<String, Object> updatedFields) {
        updatedFields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(User.class, key);
            if (isNull(field)) {
                return;
            }
            field.setAccessible(true);
            ReflectionUtils.setField(field, originalUser, value);
        });

        return originalUser;
    }

}
