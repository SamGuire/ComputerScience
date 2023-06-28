package com.example.ormsandbox.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name="app_user_refresh_token")
public class UserRefreshToken {


    @Id
    @Column(name="user_id")
    private UUID userId;

    @Column(name="refresh_token")
    private UUID refreshToken;

    @Column(name="expire_date")
    private Timestamp expireDate;


    public UserRefreshToken(){}

    public UUID getUser_id() {
        return userId;
    }

    public void setUser_id(UUID userId) {
        this.userId = userId;
    }

    public UUID getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(UUID refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Timestamp getExpire_date() {
        return expireDate;
    }

    public void setExpire_date(Timestamp expire_date) {
        this.expireDate = expire_date;
    }
}
