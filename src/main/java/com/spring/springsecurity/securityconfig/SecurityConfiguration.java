package com.spring.springsecurity.securityconfig;

import com.spring.springsecurity.UserPrincipalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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

    @Autowired
    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    private  UserPrincipalDetailsService userPrincipalDetailsService ;


/*
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

/*        users.add(User
                .withUsername("gemy")
                .password(passwordEncoder().encode("123"))
              //  .roles("ADMIN")
                .authorities("ACCESS_BASIC1","ROLE_ADMIN")
                .build());
        users.add( User
                .withUsername("ahmed")
                .password(passwordEncoder().encode("123"))
                //.roles("MANAGER")
                .authorities("ACCESS_BASIC2","ROLE_MANAGER")
                .build());
        users.add( User
                .withUsername("karim")
                .password(passwordEncoder().encode("123"))
                .roles("USER")
                .build());


     //   return new InMemoryUserDetailsManager(users);

    }
*/
    @Bean
    DaoAuthenticationProvider authenticationProvider (){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
        return daoAuthenticationProvider ;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/api/main").permitAll()
                .requestMatchers("/api/profile").authenticated()
                .requestMatchers("/api/basic/mybasic").hasAuthority("ACCESS_BASIC1")
                .requestMatchers("/api/basic/allbasic").hasAuthority("ACCESS_BASIC2")
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/manage").hasAnyRole("MANAGER","ADMIN")
                //.anyRequest()
                //.authenticated()
                .and()
               // .httpBasic(withDefaults());
                .formLogin()
                .loginProcessingUrl("/signin")
                .usernameParameter("user")
                .passwordParameter("pass")
                .loginPage("/api/login");
        return http.build();
    }




    @Bean
    PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }



    public void configure(AuthenticationManagerBuilder auth) throws Exception {
                  // auth.inMemoryAuthentication()
               // .withUser("ahmed").password("ahmed123").roles("ADMIN").and()
               // .withUser("Karim").password("karim123").roles("USER");

        auth.authenticationProvider(authenticationProvider());

    }


}
