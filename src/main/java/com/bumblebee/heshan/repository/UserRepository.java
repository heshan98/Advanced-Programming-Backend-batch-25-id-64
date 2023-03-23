package com.bumblebee.heshan.repository;

import com.bumblebee.heshan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String username);



    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
