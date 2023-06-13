package com.spring.springsecurity.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserPrincipal implements UserDetails {

    @Autowired
    public UserPrincipal(User user) {
        this.user = user;
    }

    private User user ;





    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        this.user.getAuthorities().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p.getAuthoritiesName());
            grantedAuthorities.add(authority);
        });

        System.out.println(grantedAuthorities);

        return   grantedAuthorities ;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        try {
            System.out.println("Found");
            return this.user.getActive() == 1;

        } catch (NullPointerException e) {
            System.out.println("not FOUND");
            return false;
        }

    }
}
