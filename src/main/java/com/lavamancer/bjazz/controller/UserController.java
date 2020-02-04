package com.lavamancer.bjazz.controller;

import com.lavamancer.bjazz.entity.User;
import com.lavamancer.bjazz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired UserService userService;

    @PostMapping("/public/users/login")
    public ResponseEntity<User> postLogin(@RequestParam String username, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(username, password));
    }

    @GetMapping("/public/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

}
