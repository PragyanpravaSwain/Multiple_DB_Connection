package com.it.ig.bridge.authmultiuser.mysql2.service;

import com.it.ig.bridge.authmultiuser.mysql2.entities.User;
import com.it.ig.bridge.authmultiuser.mysql2.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;

    @Override
    public User createUser(User user) {
        User savedUser = userRepo.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(User user, Integer userId) {

        Optional<User> existingUser = userRepo.findById(userId);
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setEmail(user.getEmail());

            return userRepo.save(updatedUser);
        } else {
            return null;
        }
    }

    @Override
    public User getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElse(null);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> user = this.userRepo.findAll();
        return user;
    }

    @Override
    public void deleteUser(Integer userId) {
        this.userRepo.deleteById(userId);
    }
}
