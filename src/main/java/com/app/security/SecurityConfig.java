package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("ADMIN", "USER")
                .and()
                .withUser("super").password("super").roles("SUPER", "ADMIN", "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                //default authetication
                .anyRequest().authenticated()

                //login form
                .and()
                .formLogin()

                .and()
                .httpBasic();
    }

    @Bean
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder)NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {return new BCryptPasswordEncoder();}
}
