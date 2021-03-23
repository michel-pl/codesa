package com.codesa.service.userService;

import com.codesa.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    void deleteById(Long id);

    List<User> getUsersByName(String name);
}
