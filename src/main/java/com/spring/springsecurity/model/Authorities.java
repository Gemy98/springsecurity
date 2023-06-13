package com.spring.springsecurity.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="authorities")
public class Authorities {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthoritiesName() {
        return authoritiesName;
    }

    public void setAuthoritiesName(String authoritiesName) {
        this.authoritiesName = authoritiesName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    public Authorities() {
    }

    public Authorities(String authoritiesName) {
        this.authoritiesName = authoritiesName;
    }

    @Column(name ="authorities_name")
    private String authoritiesName ;



    @ManyToMany(mappedBy = "authorities")
    private List<User> users=new ArrayList<>() ;


}
