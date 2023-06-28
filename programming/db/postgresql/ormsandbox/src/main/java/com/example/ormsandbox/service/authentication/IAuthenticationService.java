package com.example.ormsandbox.service.authentication;

import com.example.ormsandbox.Entity.UserRefreshToken;
import com.example.ormsandbox.common.HTTPException;

import java.util.Map;
import java.util.UUID;

public interface IAuthenticationService {

    public Map<String,String> login(String email, String password) throws HTTPException;

    public boolean logout(String userId);

    public String refreshAccessToken(String userId) throws HTTPException;

}
