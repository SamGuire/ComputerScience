package com.example.ormsandbox.utility.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.ormsandbox.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class JWTTokenUtil {

    /// NEVER HARCODE SECRET !!! PUT IN ENV, JUST FOR EXPERIMENTING
    static final Algorithm ALGORITHM = Algorithm.HMAC256("secret");

    static final long JWTEXPIREOFFSETSECONDS = 60;
    static final String ISSUER = "APP";

    static final JWTVerifier VERIFIER = JWT.require(ALGORITHM).withIssuer(ISSUER).build();
    public static String createToken(String user_id,String email) {
        Map<String,String> payload = new HashMap<>();
        payload.put("userId",user_id);
        payload.put("email",email);
        String jwtToken = JWT.create()
                .withIssuer(ISSUER)
                .withClaim("userId",user_id).withClaim("email",email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000*JWTEXPIREOFFSETSECONDS))
                .sign(ALGORITHM);
        return jwtToken;
    }

    public static DecodedJWT verifyToken(String token) throws JWTVerificationException {
            DecodedJWT verifiedToken = VERIFIER.verify(token);
            return verifiedToken;
    }
}
