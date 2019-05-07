package com.hellokoding.sso.auth;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
    public static String generateToken(String signingKey, String subject) {
        long nowMillis = System.currentTimeMillis();
        String apiKey = "signingKey";
        Date now = new Date(nowMillis);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey);
        Key newSigningKey = new SecretKeySpec(apiKeySecretBytes,
                SignatureAlgorithm.HS256.getJcaName());

        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, newSigningKey);

        return builder.compact();
    }

    public static String getSubject(HttpServletRequest httpServletRequest, String jwtTokenCookieName, String newSigningKey){
        String token = CookieUtil.getValue(httpServletRequest, jwtTokenCookieName);
        if(token == null) return null;
        return Jwts.parser().setSigningKey(newSigningKey).parseClaimsJws(token).getBody().getSubject();
    }
}
