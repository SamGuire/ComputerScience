package com.example.ormsandbox.service.authentication;

import com.example.ormsandbox.Entity.User;
import com.example.ormsandbox.Entity.UserRefreshToken;
import com.example.ormsandbox.common.HTTPException;
import com.example.ormsandbox.repository.user.IUserRefreshTokenRepository;
import com.example.ormsandbox.repository.user.IUserRepository;
import com.example.ormsandbox.utility.jwt.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationService implements IAuthenticationService{

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserRefreshTokenRepository refreshTokenRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    public AuthenticationService(){}
    @Override
    public Map<String,String> login(String email, String password) throws HTTPException {
        User user = userRepository.findByEmail(email);
        if (user == null || !encoder.matches(password,user.getHashed_password())) {
            throw new HTTPException(404,"Invalid username or password");
        } else {
            Map<String,String> toReturn = new HashMap<>();
            UserRefreshToken refreshToken = refreshTokenRepository.findByUserId(user.getUser_id());
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            // never do this
            final int EXPIREOFFSETMILLISSECONDS = 1000*60*60*24; //24hours

            if (refreshToken == null) {
                UserRefreshToken newRefreshToken = new UserRefreshToken();
                newRefreshToken.setUser_id(user.getUser_id());
                newRefreshToken.setExpire_date(new Timestamp(currentTimestamp.getTime()+EXPIREOFFSETMILLISSECONDS));

                String refreshTokenUUID = UUID.randomUUID().toString();
                newRefreshToken.setRefreshToken(UUID.fromString(refreshTokenUUID));

                toReturn.put("refreshToken",refreshTokenUUID);

                refreshTokenRepository.save(newRefreshToken);
            } else {
                toReturn.put("refreshToken",refreshToken.getRefreshToken().toString());
            }
            String token = JWTTokenUtil.createToken(user.getUser_id().toString(),user.getEmail());
            toReturn.put("jwt",token);
            return toReturn;
        }
    }

    @Override
    public boolean logout(String userId) {
        UserRefreshToken refreshToken = refreshTokenRepository.findByUserId(UUID.fromString(userId));
        if (refreshToken == null) {
            return true;
        } else {
            int removedTokens = refreshTokenRepository.deleteByUserId(UUID.fromString(userId));
            return removedTokens > 0;
        }
    }

    @Override
    public String refreshAccessToken(String refreshToken) throws HTTPException {
        UserRefreshToken userRefreshToken = refreshTokenRepository.findByRefreshToken(UUID.fromString(refreshToken));
        if (userRefreshToken == null) throw new HTTPException(404,"Session is not active");
        Timestamp tokenExpiredTimestamp = userRefreshToken.getExpire_date();
        if (tokenExpiredTimestamp.before(new Timestamp(System.currentTimeMillis()))) throw new HTTPException(404,"Session expired");

        User user = userRepository.findByUserId(userRefreshToken.getUser_id());

        return JWTTokenUtil.createToken(user.getUser_id().toString(),user.getEmail());

    }
}
