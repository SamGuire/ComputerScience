package com.example.ormsandbox.repository.user;

import com.example.ormsandbox.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<User,String> {
    boolean existsByEmail(String email);

    User findByEmail(String email);

    User findByUserId(UUID userId);

}
