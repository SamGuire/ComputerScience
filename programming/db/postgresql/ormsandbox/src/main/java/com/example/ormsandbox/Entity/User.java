package com.example.ormsandbox.Entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name="app_user")
public class User implements UserDetails {

    @Id
    @Column(name="user_id")
    private UUID userId;

    @Column(name="email")
    private String email;

    @Column(name="hashed_password")
    private String hashedPassword;

    public User(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getUser_id() {
        return userId;
    }

    public void setUser_id(UUID user_id) {
        this.userId = user_id;
    }

    public String getHashed_password() {
        return hashedPassword;
    }

    public void setHashed_password(String hashed_password) {
        this.hashedPassword = hashed_password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ISSAM"));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.getHashed_password();
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
