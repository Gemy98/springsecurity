package com.spring.springsecurity.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


@Component
public class UserPrincipal implements UserDetails {

    @Autowired
    public UserPrincipal(User user) {
        this.user = user;
    }

    private User user ;





    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<Authorities> authorities = new ArrayList<>();
        this.user.getAuthorities().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p.getAuthoritiesName());
            authorities.add((Authorities) authority);
        });

       Collection c =  new HashSet<GrantedAuthority>(authorities.size());


        return   c ;
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
        return this.user.getActive()==1;
    }
}
