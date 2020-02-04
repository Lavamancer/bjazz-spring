package com.lavamancer.bjazz.repository;

import com.lavamancer.bjazz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

}
