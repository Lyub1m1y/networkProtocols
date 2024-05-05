package org.rest.controller;

import lombok.RequiredArgsConstructor;
import org.rest.entity.User;
import org.rest.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("user")
    public User getUser(Long id) {
        return userService.getUserById(id);
    }

}
