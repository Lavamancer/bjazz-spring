package com.lavamancer.bjazz.service;

import com.lavamancer.bjazz.entity.User;
import com.lavamancer.bjazz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired UserRepository userRepository;


    @PostConstruct
    public void init() {
        if (userRepository.findAll().isEmpty()) {
            create("milesdavis", "miles@bjazz.com", "1234");
            create("charlieparker", "charlie@bjazz.com", "1234");
            create("sonnyrollins", "sonny@bjazz.com", "1234");
            create("dizzygillespie", "dizzy@bjazz.com", "1234");
        }
    }

    public User create(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        if (!userRepository.existsByUsernameAndPassword(username, password)) {
            throw new RuntimeException("Usuario o contraseña incorrectos");
        }
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

}
