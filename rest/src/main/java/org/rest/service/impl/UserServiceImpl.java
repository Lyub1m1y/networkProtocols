package org.rest.service.impl;

import lombok.RequiredArgsConstructor;
import org.rest.entity.User;
import org.rest.repository.UserRepository;
import org.rest.service.UserService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        return userRepository.getReferenceById(userId);
    }

}
