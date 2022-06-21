package com.guavapay.task.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenUtil {

    @Value("${jwt.token.private-key}")
    private String privateKey;

    @Value("${jwt.token.public-key}")
    private String publicKey;

    public String createToken(String username, JwtTokenType type) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + type.getValidityTime());
        return Jwts.builder()
                .setClaims(type.apply(username))
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.RS256, getPrivateKey())
                .compact();
    }

    private PrivateKey getPrivateKey() {
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
            return kf.generatePrivate(keySpecPKCS8);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }


}
