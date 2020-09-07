package com.spiritual.note.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //if i have many urls, i will set all in array
    public final String[] UNAUTH_ENDPOINTS={
            "/api/users/",
            "/api/notes/"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
        //i don't have or use cookies so i'm gonna disable it
        .cors().and().csrf().disable()

        //i will use JWT so i don't need session
        .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        //which url request will be authorized
        .and().authorizeRequests()
        // any request with this urls can access data without authorization
                .antMatchers(UNAUTH_ENDPOINTS).permitAll()

        //any other requests must be authenticated
        .anyRequest().authenticated()
        // i will use http basic authorization which need username and password only
        .and().httpBasic();


    }
}
