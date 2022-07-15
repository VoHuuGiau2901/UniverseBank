package com.ec.final_project.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests().antMatchers("/Welcome/**").permitAll();
        http.authorizeHttpRequests().antMatchers("/Admin/**").hasAnyAuthority("USER");

        CustomAuthenticationFilter customAuthenicationFilter = new CustomAuthenticationFilter(super.authenticationManagerBean());
        customAuthenicationFilter.setFilterProcessesUrl("/Welcome/Login");
        http.addFilter(customAuthenicationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), customAuthenicationFilter.getClass());
    }
}
