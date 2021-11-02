package br.com.codersolution.cshotel.service.security;

import br.com.codersolution.cshotel.model.security.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {

        User usuario = (User) authentication.getPrincipal();

        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(expiration));

        return Jwts.builder().setIssuer("MinhaAplicacao")
                .setSubject(usuario.getId())
                .setIssuedAt(new Date())
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getTokenId(String token) {
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return body.getSubject();
    }
}