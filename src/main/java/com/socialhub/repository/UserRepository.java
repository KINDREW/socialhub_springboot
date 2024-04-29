package com.socialhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialhub.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByUsername(String username);

    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE (u.username = ?1 OR u.email = ?1) AND u.password = ?2")
    User findByUsernameAndPassword(String usernameOrEmail, String password);
}
