package com.ec.final_project.security;

import com.ec.final_project.Services.Services.accountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;

    @Autowired
    private com.ec.final_project.Services.Services.accountService accountService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
                .cors()
                .and()
                .authorizeHttpRequests().antMatchers("/Welcome/**", "/oauth2/**").permitAll()
                .and()
                .authorizeHttpRequests().antMatchers("/Admin/**").hasAnyAuthority("USER")
                .and()
                .oauth2Login()
                .authorizationEndpoint()
                .baseUri("/oauth2/authorize/")
                .authorizationRequestRepository(new HttpCookieOAuth2AuthorizationRequestRepository())
                .and()
                .redirectionEndpoint()
                .baseUri("/oauth2/callback/*")
                .and()
                .userInfoEndpoint()
                .userService(new CustomOAuth2UserService())
                .and()
                .successHandler(oAuth2AuthenticationSuccessHandler);

        CustomAuthenticationFilter customAuthenicationFilter = new CustomAuthenticationFilter(super.authenticationManagerBean(), accountService);
        customAuthenicationFilter.setFilterProcessesUrl("/Welcome/Login");
        http.addFilter(customAuthenicationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), customAuthenicationFilter.getClass());

    }
}
