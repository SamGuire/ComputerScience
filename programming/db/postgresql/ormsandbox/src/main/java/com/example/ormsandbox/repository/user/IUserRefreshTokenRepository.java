package com.example.ormsandbox.repository.user;

import com.example.ormsandbox.Entity.UserRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRefreshTokenRepository extends JpaRepository<UserRefreshToken,String> {
    UserRefreshToken findByUserId(UUID userId);

    UserRefreshToken findByRefreshToken(UUID refreshToken);
    int deleteByUserId(UUID userId);
}
