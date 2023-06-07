package com.spring.springsecurity.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
      /*  UserDetails user1 = User
                .withUsername("gemy")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();

        UserDetails user2 = User
                .withUsername("ahmed")
                .password(passwordEncoder().encode("123"))
                .roles("MANAGER")
                .build();

        UserDetails user3 = User
                .withUsername("karim")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build();
        */

        List<UserDetails> users = new ArrayList<>();
        users.add(User
                .withUsername("gemy")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build());
        users.add( User
                .withUsername("ahmed")
                .password(passwordEncoder().encode("123"))
                .roles("MANAGER")
                .build());
        users.add( User
                .withUsername("karim")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build());


        return new InMemoryUserDetailsManager(users);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/api/main").permitAll()
                .requestMatchers("/api/profile").authenticated()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/manage").hasAnyRole("MANAGER","ADMIN")
                //.anyRequest()
                //.authenticated()
                .and()
                .httpBasic(withDefaults());
        return http.build();
    }




    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }


/*
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("ahmed").password("ahmed123").roles("ADMIN").and()
                .withUser("Karim").password("karim123").roles("USER");

    }

 */
}
