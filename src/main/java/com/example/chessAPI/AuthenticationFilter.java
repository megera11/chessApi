package com.example.chessAPI;

import com.example.chessAPI.models.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Account account = new ObjectMapper().readValue(request.getInputStream(), Account.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getLogin(),account.getPassword(), new ArrayList<>()));
        } catch (IOException ioException) {
            throw new RuntimeException("Could not read request");
        }
    }

    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain,Authentication authentication){
        String token = Jwts.builder().setSubject(((Account) authentication.getPrincipal()).getLogin())
                                     .setExpiration(new Date(System.currentTimeMillis()+ 864_000_000))
                                     .signWith(SignatureAlgorithm.HS512,"beastlord".getBytes())
                                     .compact();
        response.addHeader("Authorization","Bearer"+token);
    }
}
