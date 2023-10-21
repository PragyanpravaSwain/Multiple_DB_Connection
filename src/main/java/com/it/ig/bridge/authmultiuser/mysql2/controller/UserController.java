package com.it.ig.bridge.authmultiuser.mysql2.controller;

import com.it.ig.bridge.authmultiuser.mysql2.entities.User;
import com.it.ig.bridge.authmultiuser.mysql2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createUsers = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUsers);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer userId){
        User updateUsers = userService.updateUser(user, userId);
        return ResponseEntity.ok(updateUsers);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted Successfully",HttpStatus.NO_CONTENT);
    }

}
