package com.ec.final_project.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ec.final_project.Utils.SecurityUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

public class CustomAuthenicationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public CustomAuthenicationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Map<String, String> login_req = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            login_req = mapper.readValue(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())), Map.class);
        } catch (IOException e) {
//            e.printStackTrace();
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login_req.get("username"), login_req.get("password"));
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //        return super.attemptAuthentication(request, response);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        System.out.println("successfulAuthentication");
        User user =(User)authResult.getPrincipal();
//        super.successfulAuthentication(request, response, chain, authResult);
        String token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(SecurityUtils.TIME_EXPIRED())
                .withIssuer(request.getRequestURL().toString())
                .withClaim("role","USER")
                .sign(SecurityUtils.ENCODE_ALGORITHM());
        Map<String, String> tokens = new HashMap<>();
        tokens.put("tokens", token);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }
}
