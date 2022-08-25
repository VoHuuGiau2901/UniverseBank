package com.ec.final_project.security;

import com.auth0.jwt.JWT;
import com.ec.final_project.Services.Services.accountService;
import com.ec.final_project.Utils.SecurityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final accountService accountService;

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, com.ec.final_project.Services.Services.accountService accountService) {
        this.authenticationManager = authenticationManager;
        this.accountService = accountService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Map<String, String> login_req = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            login_req = mapper.readValue(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())), HashMap.class);
        } catch (IOException e) {
//            e.printStackTrace();
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login_req.get("username"), login_req.get("password"));

        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), "USER_NOT_FOUND");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        System.out.println("successfulAuthentication");
        User user = (User) authResult.getPrincipal();
        int UserId= accountService.findByUsername(user.getUsername()).getAcc_id();
        String access_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(SecurityUtils.ACCESS_TIME_EXPIRED)
                .withIssuer(request.getRequestURL().toString())
                .withClaim("role", "USER")
                .sign(SecurityUtils.ENCODE_ALGORITHM);

        String refresh_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(SecurityUtils.REFRESH_TIME_EXPIRED)
                .withIssuer(request.getRequestURL().toString())
                .sign(SecurityUtils.ENCODE_ALGORITHM);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", refresh_token);
        tokens.put("userId", String.valueOf(UserId));

        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }
}
