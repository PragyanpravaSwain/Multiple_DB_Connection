package com.it.ig.bridge.authmultiuser.mysql2.service;

import com.it.ig.bridge.authmultiuser.mysql2.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User updateUser(User user, Integer userId);
    User getUserById(Integer userId);
    List<User> getAllUser();
    void deleteUser(Integer userId);
}
