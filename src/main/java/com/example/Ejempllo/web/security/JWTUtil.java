package com.example.Ejempllo.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
@Component
public class JWTUtil {

    private static final String key= "platzi";
    public String generateToken(UserDetails userDetails){
        /*
        Los datos ingresados crean el jwt, primero el usuario, despues fecha de creacion, fecha expiracion (10 horas) y despues
        la firma con su key previamente definida
         */
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256, key ).compact();

    }

    public boolean validateToken(String token, UserDetails userDetails){

        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);

    }

    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }
    public boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();

    }
}
