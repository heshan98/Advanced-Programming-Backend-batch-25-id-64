package com.bumblebee.heshan.repository;

import com.bumblebee.heshan.model.ERole;
import com.bumblebee.heshan.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);

}
